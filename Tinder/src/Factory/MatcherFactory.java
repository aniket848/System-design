package Factory;

import Enums.MatcherType;
import Matcher.*;

// SINGLETON
public class MatcherFactory {

    private static MatcherFactory instance = null;

    private MatcherFactory(){}

    public static MatcherFactory getInstance(){
        if(instance == null){
            instance = new MatcherFactory();
        }
        return instance;
    }

    public Matcher createrMatcher(MatcherType matcherType){
        return switch (matcherType){
            case BASIC -> new BasicMatcher();
            case INTEREST -> new InterestMatcher();
            default -> new DistanceMatcher();
        };
    }
}
