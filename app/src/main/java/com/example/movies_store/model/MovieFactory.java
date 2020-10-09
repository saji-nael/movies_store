package com.example.movies_store.model;

public class MovieFactory {
    public IMovieDa getModel(){
        return new MovieDa();
    }
}
