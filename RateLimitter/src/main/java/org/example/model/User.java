package org.example.model;

import org.example.Enum.Usertier;

public class User {
    private String userId;
    private String name;
    private Usertier usertier;

    public User(String userId, String name, Usertier usertier) {
        this.userId = userId;
        this.name = name;
        this.usertier = usertier;
    }

    public Usertier getUsertier() {
        return usertier;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
