package com.example.movies_store.model;

public class Movie {
    //define attributes
    private String movieTitle;
    private int movieYear;
    private String movieCategory;
    //define class constructor,getter and setter methods


    public Movie(String movieTitle, int movieYear, String movieCategory) {
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieCategory = movieCategory;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }
}
