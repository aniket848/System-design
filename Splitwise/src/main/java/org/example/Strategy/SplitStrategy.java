package org.example.Strategy;

import org.example.Enum.SplitType;
import org.example.Model.Split;
import org.example.Model.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {

    List<Split> split(SplitType type, Double totalAmount, List<User> participants,
                      Map<User, Double> metadata);
}
