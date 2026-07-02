package org.example;

import org.example.Enum.Speciality;
import org.example.Model.Doctor;
import org.example.Repo.BookingRepo;
import org.example.Repo.DoctorRepo;
import org.example.Repo.PatientRepo;
import org.example.Service.BookingService;
import org.example.Service.DoctorService;
import org.example.Service.PatientService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DoctorRepo  doctorRepo  = new DoctorRepo();
        PatientRepo patientRepo = new PatientRepo();
        BookingRepo bookingRepo = new BookingRepo();

        DoctorService  doctorService  = new DoctorService(doctorRepo, bookingRepo, patientRepo);
        PatientService patientService = new PatientService(patientRepo);
        BookingService bookingService = new BookingService(bookingRepo, doctorRepo, patientRepo);

        doctorService.register("D-101","Devyansh","9.0", Speciality.CARDIOLOGIST);
        doctorService.register("D-102","Aarti","8.75", Speciality.CARDIOLOGIST);
        doctorService.register("D-103","Rohit","9.5", Speciality.DERMATOLOGIST);
        doctorService.register("D-104","Aniket","6.5", Speciality.CARDIOLOGIST);

        //System.out.println("Total doctors: " + doctorRepo.getAllDoctors().size());

        patientService.registerPatient("Harsh");
        patientService.registerPatient("Mehak");
        patientService.registerPatient("Swati");

        doctorService.addSlots("D-101", List.of("09:30","11:00","12:30"));
        doctorService.addSlots("D-102", List.of("10:00","11:00","14:00"));
        doctorService.addSlots("D-103", List.of("09:00","11:00"));

        System.out.println("Show all doctors with speciality "+Speciality.CARDIOLOGIST);
        System.out.println("--------------------------------------------------");
        List<Doctor> doctors = doctorService.getDoctorBySpeciality(Speciality.CARDIOLOGIST);
        doctors.forEach(doctor -> {
            System.out.println("Doctor Id: "+doctor.getId()+" Name: "+doctor.getName()+" Rating: "+doctor.getRating());
        });

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Trying booking with incorrect slot");
        try{
            bookingService.book("Swati","D-101","11:30");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Try correct booking");
        String bookingId1 = bookingService.book("Swati","D-101","11:00");

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Show All booking of doctor");
        doctorService.showAllDoctorBookings("D-101");

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Try with same booking for diff user");
        try{
            bookingService.book("Harsh","D-101","11:00");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Cancel booking of Swati");
        bookingService.cancelBooking(bookingId1);

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Show All booking of doctor");
        doctorService.showAllDoctorBookings("D-101");
    }
}
