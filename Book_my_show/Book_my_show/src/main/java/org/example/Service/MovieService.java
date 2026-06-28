package org.example.Service;

import org.example.Model.Movie;
import org.example.Repo.MovieRepository;

import java.util.List;

public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public void save(Movie movie){
        movieRepository.save(movie);
    }

    public List<Movie> findByTitle(String name){
       return movieRepository.getAllMoviesByTitle(name);
    }
}
