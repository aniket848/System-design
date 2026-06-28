package org.example.Repo;

import org.example.Model.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {

    private Map<String, Movie> movieMap = new HashMap<>();

    public void save(Movie movie){
        String id = movie.getId();
         movieMap.put(id,movie);
    }

    public Movie getMovieById(String id){

        return movieMap.getOrDefault(id,null);
    }


    public List<Movie> getAllMoviesByTitle(String name){
         Collection<Movie> movieList = movieMap.values();
//        System.out.println("All movies list");
//         for(Movie m : movieList){
//             System.out.println(m.getName());
//         }
         return movieList.stream().
                 filter(movie-> movie.getName().contains(name))
                 .toList();
    }
}
