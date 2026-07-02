package org.example.Repo;

import org.example.Enum.Speciality;
import org.example.Model.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorRepo {

    private final HashMap<String, Doctor> doctorList = new HashMap<>();

    public void saveDoctor(Doctor doctor){
        //System.out.println("save doctor called for "+doctor.getName());
        doctorList.put(doctor.getId(),doctor);
    }

    public Doctor getDoctorById(String id){
        //System.out.println("doctor id = " + id);
        //System.out.println("total doctors size = "+doctorList.size());
        return doctorList.get(id);
    }

    public List<Doctor> getAllDoctors(){
        return new ArrayList<>(doctorList.values());
    }

}
