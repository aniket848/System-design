package org.example.Repo;

import org.example.Model.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientRepo {

    private HashMap<String, Patient> patientList = new HashMap<>();

    public Patient getPatientById(String id){
        return patientList.get(id);
    }

    public void savePatient(Patient patient){
        patientList.put(patient.getId(),patient);
    }

    public List<Patient> getAllPatients(){
        return new ArrayList<>(patientList.values());
    }

    public Patient getPatientByName(String name){
        //System.out.println("patient name = " + name);
        for(Patient patient : patientList.values()){
            if(patient.getName().equals(name))
                return patient;
        }
        return null;
    }
}
