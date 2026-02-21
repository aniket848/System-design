package Matcher;

import Engine.User;

public class InterestMatcher implements Matcher{

    private BasicMatcher basicMatcher = null;


    @Override
    public Double calculateMatchScore(User user1, User user2) {

        basicMatcher = new BasicMatcher();
        Double baseScore = basicMatcher.calculateMatchScore(user1, user2);
        if(baseScore == 0.0){
            return 0.0;
        }

        boolean user1LikedUser2Interests = user1.getPreferences().isInterestedInCommonInterests(user2.getProfile().getHobbies());
        boolean user2LikedUser1Interests = user2.getPreferences().isInterestedInCommonInterests(user1.getProfile().getHobbies());

        if(!user1LikedUser2Interests || !user2LikedUser1Interests){
            return baseScore;
        }

        return baseScore + 0.2;// extra 0.2 score for common interests
    }
}
