package org.example.Service;

import org.example.Model.Booking;
import org.example.Model.Doctor;
import org.example.Model.Patient;
import org.example.Repo.BookingRepo;
import org.example.Repo.DoctorRepo;
import org.example.Repo.PatientRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BookingService {

    private BookingRepo bookingRepo;
    private DoctorRepo doctorRepo;
    private PatientRepo patientRepo;

    private HashMap<String, Queue<Patient>> waitingList = new HashMap<>();

    public BookingService(BookingRepo bookingRepo, DoctorRepo doctorRepo, PatientRepo patientRepo) {
        this.bookingRepo = bookingRepo;
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
    }

    public String book(String patientName, String doctorId, String slot){
        Doctor doctor = doctorRepo.getDoctorById(doctorId);
        Patient patient = patientRepo.getPatientByName(patientName);

        if(doctor == null){
            throw new RuntimeException("Doctor Not Found");
        }

        if(!doctor.getIsAvailable().containsKey(slot)){
            throw new RuntimeException("Slot Not Found for doctor "+doctor.getName());
        }

        Map<String,Boolean> isAvailable = doctor.getIsAvailable();

        if(isAvailable.get(slot)){
            Booking booking = new Booking(doctorId,patient.getId(), slot);
            bookingRepo.saveBooking(booking);
            doctor.getIsAvailable().put(slot, false);

            System.out.println("Booking Confirmed for Patient "+patient.getName()+" with Doctor "+doctor.getName()+" at slot "+slot);
            return booking.getBookingId();
        }
        else{
            String key = slot + "-" + doctorId;
            waitingList.putIfAbsent(key, new java.util.LinkedList<>());

            Queue<Patient> queue = waitingList.get(key);
            queue.offer(patient);
            throw new RuntimeException("Slot Not Available, Patient Added to Waiting List");
        }
    }

    public void cancelBooking(String bookingId){
        Booking booking = bookingRepo.getBooking(bookingId);
        Doctor doctor = doctorRepo.getDoctorById(booking.getDoctorId());

        bookingRepo.removeBooking(booking);
        doctor.getIsAvailable().put(booking.getSlot(), true);
        System.out.println("Booking Cancelled for Patient "+booking.getPatientId()+" with Doctor "+booking.getDoctorId()+" at slot "+booking.getSlot());

        String key = booking.getSlot() + "-" + booking.getDoctorId();
        Queue<Patient> queue = waitingList.get(key);
        if(queue != null && !queue.isEmpty()){
            Patient patient = queue.poll();
            System.out.println("Booking is confirmed for waitingList patient "+patient.getName()+" with Doctor "+booking.getDoctorId()+" at slot "+booking.getSlot());
            book(patient.getName(), booking.getDoctorId(), booking.getSlot());
        }
    }

    public List<Booking> getAllBookingByDoctor(String doctorId) {
        return bookingRepo.getAllBookingByDoctor(doctorId);
    }
}
