package com.example.movies_store.model;

import java.util.ArrayList;
import java.util.List;

public interface IMovieDa {
    //define abstract methods
    public List<Movie> getMovieByCategory(String cat);
    public List<Movie> getMovieByTitle(String title);
    public List<Movie> getMovieByYear(int year);

}
