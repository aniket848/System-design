package org.example.Strategy;

import org.example.Model.Doctor;

import java.util.Comparator;
import java.util.List;

public class RankBasedStrategy implements RankStrategy {

    @Override
    public List<Doctor> getDoctors(List<Doctor> doctors) {

        doctors.sort((a,b)->Double.compare(b.getRating(),a.getRating()));

        return doctors;
    }
}
