package org.example.Model;

import java.util.List;

public class Theatre {

    private String id;
    private String name;
    private List<Screen> screenList;

    public Theatre(String id, String name, List<Screen> screenList) {
        this.id = id;
        this.name = name;
        this.screenList = screenList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }
}
