package org.example.Model;

public class Show {

    private String id;
    private Movie movie;
    private Theatre theatre;

    public Show(String id, Movie movie, Theatre theatre) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }
}
