import Engine.User;
import Enums.Gender;
import Model.Location;
import Model.userPreference;
import Model.userProfile;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Tinder tinder = new Tinder();

        // CREATE Ist USER

        System.out.println(" USER LIST ");

        userProfile profile1 = new userProfile("Aniket",25, new Location(1.02,1.03), Gender.MALE);
        profile1.addHobbies("Singing");
        profile1.addHobbies("Coding");
        profile1.addHobbies("Cricket");
        profile1.addHobbies("Politics");
        profile1.addHobbies("Gym");
        profile1.addBio("I am a software engineer who loves to sing and play cricket.");

        userPreference preference1 = new userPreference(20,30, Gender.FEMALE, 10.0);
        preference1.addInterest("Dancing");
        preference1.addInterest("Cooking");
        preference1.addInterest("Politics");

        User user1 = new User((long)101,profile1,preference1);
        user1.showUserProfile();
        tinder.addUser(user1);

        // CREATE 2nd USER

        userProfile profile2 = new userProfile("Jahnvi",23, new Location(1.04,1.05), Gender.FEMALE);
        profile2.addHobbies("Dancing");
        profile2.addHobbies("Politics");
        profile2.addHobbies("Acting");
        profile2.addBio("I am a dancer who loves to act and discuss politics.");

        userPreference preference2 = new userPreference(24,30, Gender.MALE, 10.0);
        preference2.addInterest("Gym");
        preference2.addInterest("Coding");
        preference2.addInterest("Politics");
        preference2.addInterest("Sports");

        User user2 = new User((long)102,profile2,preference2);
        user2.showUserProfile();
        tinder.addUser(user2);

        // CREATE 3rd USER

        userProfile profile3 = new userProfile("Harsh",25, new Location(2.04,2.05), Gender.MALE);
        profile3.addHobbies("Singing");
        profile3.addHobbies("Coding");
        profile3.addHobbies("Cricket");
        profile3.addHobbies("Politics");
        profile3.addHobbies("Gym");
        profile3.addBio("I am a dancer who loves to act and discuss politics.");

        userPreference preference3 = new userPreference(22,30, Gender.FEMALE, 10.0);
        preference3.addInterest("Gym");
        preference3.addInterest("Coding");
        preference3.addInterest("Politics");

        User user3 = new User((long)103,profile3,preference3);
        user3.showUserProfile();
        tinder.addUser(user3);

        // SHOW AVAILABLE PROFILES FOR USER 1
        System.out.println("Available profiles for " + user1.getProfile().getName() + ":");
        List<User> availableMatchesForUser1 = tinder.findMatches(user1.getUserId());
        for(User user : availableMatchesForUser1){
            user.showUserProfile();
        }
        System.out.println();

        // SHOW AVAILABLE PROFILES FOR USER 2
        System.out.println("Available profiles for " + user2.getProfile().getName() + ":");
        List<User> availableMatchesForUser2 = tinder.findMatches(user2.getUserId());
        for(User user : availableMatchesForUser2){
            user.showUserProfile();
        }
        System.out.println();

        // USER 1 SWIPES RIGHT ON USER 2
        System.out.println(user1.getProfile().getName() + " swipes right on " + user2.getProfile().getName());
        tinder.swipe(user1.getUserId(), user2.getUserId(), Enums.SwipeAction.RIGHT);
        System.out.println();

        // USER 2 SWIPES RIGHT ON USER 1
        System.out.println(user2.getProfile().getName() + " swipes right on " + user1.getProfile().getName());
        tinder.swipe(user2.getUserId(), user1.getUserId(), Enums.SwipeAction.RIGHT);
        System.out.println();

        // AFTER MATCHING, BOTH START CHATTING
        tinder.sendMessage(user1.getUserId(), user2.getUserId(), "Hi Jahnvi! Nice to match with you.");
        tinder.sendMessage(user2.getUserId(), user1.getUserId(), "Hi Aniket! How are you?");
        tinder.sendMessage(user1.getUserId(), user2.getUserId(), "Hi Jahnvi! What are you doing in the evening");
        tinder.sendMessage(user2.getUserId(), user1.getUserId(), "Nothing special, just chilling at home. What about you?");


        // DISPLAY CHAT HISTORY
        System.out.println();
        System.out.println("Chat history between " + user1.getProfile().getName() + " and " + user2.getProfile().getName() + ":");
        tinder.displayMessage(user1.getUserId(),user2.getUserId());
    }
}