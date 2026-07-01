package org.example.Factory;

import org.example.Enum.SplitType;
import org.example.Strategy.EqualSplitStrategy;
import org.example.Strategy.PercentageSplitStrategy;
import org.example.Strategy.SplitStrategy;

public class SplitFactory {

    public SplitFactory() {}

    public static SplitStrategy createSplitStrategy(SplitType type){
        return switch(type){
            case EQUAL -> new EqualSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
        };
    }
}
