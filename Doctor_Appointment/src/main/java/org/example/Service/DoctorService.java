package org.example.Service;

import org.example.Enum.Speciality;
import org.example.Model.Booking;
import org.example.Model.Doctor;
import org.example.Model.Patient;
import org.example.Repo.BookingRepo;
import org.example.Repo.DoctorRepo;
import org.example.Repo.PatientRepo;
import org.example.Strategy.RankBasedStrategy;
import org.example.Strategy.RankStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoctorService {

    private DoctorRepo doctorRepo;
    private BookingRepo bookingRepo;
    private PatientRepo patientRepo;
    private RankStrategy rankStrategy = new RankBasedStrategy();

    public DoctorService(DoctorRepo doctorRepo, BookingRepo bookingRepo, PatientRepo patientRepo) {
        this.doctorRepo = doctorRepo;
        this.bookingRepo = bookingRepo;
        this.patientRepo = patientRepo;
    }

    public List<Doctor> getDoctorBySpeciality(Speciality speciality){
        List<Doctor> doctors = doctorRepo.getAllDoctors();

        List<Doctor> res = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getSpeciality().equals(speciality)){
                res.add(doctor);
            }
        }

        return rankStrategy.getDoctors(res);
    }

    public Doctor getDoctorById(String id){
        return doctorRepo.getDoctorById(id);
    }

    public void addSlots(String doctorId, List<String> slots){
        Doctor doctor = doctorRepo.getDoctorById(doctorId);
        doctor.addSlots(slots);
    }

    public Boolean isSlotAvailable(String slot, String doctorId){
        Doctor doctor = doctorRepo.getDoctorById(doctorId);

        for(Map.Entry<String,Boolean> entry : doctor.getIsAvailable().entrySet()){
            if(entry.getKey().equals(slot) && entry.getValue()){
                return true;
            }
        }

        return false;
    }

    public void register(String id, String name, String rating, Speciality speciality){
        Doctor doctor = new Doctor(id, name, speciality, Double.parseDouble(rating));
        doctorRepo.saveDoctor(doctor);
    }

    public void showAllDoctorBookings(String doctorId){
        List<Booking> bookings = bookingRepo.getAllBookingByDoctor(doctorId);

        if(bookings.isEmpty()){
            System.out.println("No Bookings Found for Doctor "+ doctorId);
        }

        for(Booking booking : bookings){
            Patient patient = patientRepo.getPatientById(booking.getPatientId());
            System.out.println("Booking ID: "+booking.getBookingId()+" Patient Name: "+patient.getName()+" Slot: "+booking.getSlot());
        }
    }

}
