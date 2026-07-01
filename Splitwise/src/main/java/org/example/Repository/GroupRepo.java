package org.example.Repository;

import org.example.Model.Group;

import java.util.HashMap;

public class GroupRepo {

    private HashMap<String, Group> groups =  new HashMap<>();

    public Group getGroup(String groupId){
        return groups.get(groupId);
    }

    public void addGroup(Group group){
        groups.put(group.getId(), group);
    }

    public void showAllGroups(){
        for(Group group : groups.values()){
            System.out.println(group.getName());
        }
    }
}
