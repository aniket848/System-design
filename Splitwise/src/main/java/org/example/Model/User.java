package org.example.Model;

public class User {
    private String id;
    private String name;

    public User(String id, String name) {
        System.out.println();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
