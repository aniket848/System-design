package org.example.Model;

import java.util.UUID;

public class Booking {

    private String bookingId;
    private String doctorId;
    private String patientId;
    private String slot;

    public Booking(String doctorId, String patientId, String slot) {
        this.bookingId = UUID.randomUUID().toString();
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.slot = slot;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getSlot() {
        return slot;
    }
}
