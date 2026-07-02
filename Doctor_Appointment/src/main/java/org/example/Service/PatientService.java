package org.example.Service;

import org.example.Model.Patient;
import org.example.Repo.PatientRepo;

import java.util.List;

public class PatientService {

    private PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public void registerPatient(String name){
        Patient patient = new Patient(name);
        patientRepo.savePatient(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepo.getAllPatients();
    }

    public Patient getPatientById(String id){
        return patientRepo.getPatientById(id);
    }

    public Patient getPatientByName(String patientName) {
        return patientRepo.getPatientByName(patientName);
    }
}
