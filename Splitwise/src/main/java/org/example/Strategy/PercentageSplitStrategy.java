package org.example.Strategy;

import org.example.Enum.SplitType;
import org.example.Model.Split;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> split(SplitType type, Double totalAmount, List<User> participants, Map<User, Double> metadata) {

        Double total = metadata.values().stream().reduce(0.0,Double::sum);

        if(total!=100){
            throw new IllegalArgumentException("Total amount must be 100");
        }

        List<Split> splits = new ArrayList<>();
        for(Map.Entry<User, Double> entry : metadata.entrySet()){
            Double share = (entry.getValue()*totalAmount)/100;
            Split split = new Split(entry.getKey(), share);
            splits.add(split);
        }

        return splits;
    }
}
