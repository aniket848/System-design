package org.example.Model;

import org.example.Enum.Speciality;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Doctor {

    private String id;
    private String name;
    private Speciality speciality;
    private Double rating;
    private Map<String,Boolean> isAvailable;

    public Doctor(String id,String name, Speciality speciality, Double rating) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.rating = rating;
        this.isAvailable = new HashMap<>();
    }

    public void addSlots(List<String> slots){
        for(String slot:slots){
            isAvailable.putIfAbsent(slot,true);
        }
    }

    public String getId() {
        return id;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public String getName() {
        return name;
    }

    public Double getRating() {
        return rating;
    }

    public Map<String, Boolean> getIsAvailable() {
        return isAvailable;
    }
}
