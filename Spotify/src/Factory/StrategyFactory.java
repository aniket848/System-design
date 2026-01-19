package Factory;

import Enum.StrategyType;
import Strategy.CustomStrategy;
import Strategy.PlaylistStrategy;
import Strategy.RandomStrategy;
import Strategy.SequentialStrategy;

public class StrategyFactory {

    public PlaylistStrategy createStrategy(StrategyType strategy){

        return switch (strategy){
            case SEQUENTIAL -> new SequentialStrategy();
            case RANDOM -> new RandomStrategy();
            default -> new CustomStrategy();
        };
    }
}
