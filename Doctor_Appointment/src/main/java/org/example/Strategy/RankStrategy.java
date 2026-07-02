package org.example.Strategy;

import org.example.Model.Doctor;

import java.util.List;

public interface RankStrategy {

    public List<Doctor> getDoctors(List<Doctor> doctors);
}
