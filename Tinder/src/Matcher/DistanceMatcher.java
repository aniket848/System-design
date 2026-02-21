package Matcher;

import Engine.User;

public class DistanceMatcher implements Matcher{

    private InterestMatcher interestMatcher = null;

    @Override
    public Double calculateMatchScore(User user1, User user2) {

        interestMatcher = new InterestMatcher();
        Double baseScore = interestMatcher.calculateMatchScore(user1, user2);

        if(baseScore == 0.0){
            return 0.0;
        }

        Double distance = user1.getProfile().getLocation().getDistance(user2.getProfile().getLocation());
        Double maxDistanceUser1 = user1.getPreferences().getMaxDistance();
        Double maxDistanceUser2 = user2.getPreferences().getMaxDistance();

        Double maxDistance = Math.max(maxDistanceUser1, maxDistanceUser2);

        if(distance > maxDistanceUser1 || distance > maxDistanceUser2){
            return baseScore;
        }

        return baseScore + 0.2 * (1 - distance/maxDistance); // extra score for distance, the closer the distance the higher the score

    }
}
