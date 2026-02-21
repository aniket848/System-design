package Matcher;

import Engine.User;

public class BasicMatcher implements Matcher {

    @Override
    public Double calculateMatchScore(User user1, User user2) {

        boolean isUser1LikedUser2Gender = user1.getPreferences().getInteresetGender().
                equals(user2.getProfile().getGender());
        boolean isUser2LikedUser1Gender = user2.getPreferences().getInteresetGender().
                equals(user1.getProfile().getGender());

        // IF EITHER USER NOT INTERESTED IN GENDER, THEN MATCH SCORE IS 0
        if (!isUser1LikedUser2Gender || !isUser2LikedUser1Gender) {
            return 0.0;
        }

        boolean isUser1LikedUser2Age = user1.getPreferences().isAgeEligible(user2.getProfile().getAge());
        boolean isUser2LikedUser1Age = user2.getPreferences().isAgeEligible(user1.getProfile().getAge());

        // IF EITHER USER NOT INTERESTED IN AGE, THEN MATCH SCORE IS 0
        if (!isUser1LikedUser2Age || !isUser2LikedUser1Age) {
            return 0.0;
        }

        boolean isUser1LiveNearByUser2 = user1.getPreferences().isWithinDistance(
                user1.getProfile().getLocation().getDistance(user2.getProfile().getLocation())
        );

        boolean isUser2LiveNearByUser1 = user2.getPreferences().isWithinDistance(
                user2.getProfile().getLocation().getDistance(user1.getProfile().getLocation())
        );

        // IF EITHER USER NOT INTERESTED IN DISTANCE, THEN MATCH SCORE IS 0
        if (!isUser1LiveNearByUser2 || !isUser2LiveNearByUser1) {
            return 0.0;
        }

        return 0.5;
    }
}

