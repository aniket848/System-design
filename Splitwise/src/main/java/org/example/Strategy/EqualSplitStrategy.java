package org.example.Strategy;

import org.example.Enum.SplitType;
import org.example.Model.Split;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> split(SplitType type, Double totalAmount, List<User> participants,
                             Map<User, Double> metadata) {
        int numberOfParticipants = participants.size();
        Double equalShare = totalAmount / numberOfParticipants;

        List<Split> splits = new ArrayList<>();
        for(User user:participants){
            Split split = new Split(user,equalShare);
            splits.add(split);
        }

        return splits;
    }
}
