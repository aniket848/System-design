package org.example.Model;

import java.util.UUID;

public class Patient {

    private String id;
    private String name;

    public Patient(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
