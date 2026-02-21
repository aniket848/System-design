package Matcher;

import Engine.User;

public interface Matcher {

    public Double calculateMatchScore(User user1, User user2);
}
