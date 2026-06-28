package org.example.Repo;

import org.example.Model.Movie;
import org.example.Model.Show;

import java.util.HashMap;
import java.util.Map;

public class ShowRepository {

    private Map<String, Show> showMap = new HashMap<>();

    public void save(Show show){
        String id = show.getId();
        showMap.put(id,show);
    }

    public Show getShowById(String id){

        return showMap.getOrDefault(id,null);
    }


}
