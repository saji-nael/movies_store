package com.example.movies_store.model;

import java.util.ArrayList;
import java.util.List;

public class MovieDa implements IMovieDa {
    //define arraylist
    private ArrayList<Movie> movies=new ArrayList<Movie>();
    public MovieDa(){
        //add movies
        movies.add(new Movie("Terminator 2: Judgment Day",1991, "Action"));
        movies.add(new Movie("The Road Warrior ",1962, "Action"));
        movies.add(new Movie("Pan's Labyrinth ",2005, "Fantasy"));
        movies.add(new Movie("The Walking Dead",2011, "Horror"));
        movies.add(new Movie(" Lovecraft Country",2020, "Horror"));
        movies.add(new Movie(" American Horror Story",2011, "Horror"));
        movies.add(new Movie("  Game of Thrones",2011, "Romance "));
        movies.add(new Movie("  Emily in Paris",2020, "Romance "));
        movies.add(new Movie("  The Good Place",2016, "Romance "));
        movies.add(new Movie("  Friends",1994, "Romance "));
        movies.add(new Movie("   Archer",2009, "Animation  "));
        movies.add(new Movie("   Jurassic World: Camp Cretaceous ",2020, "Animation  "));
    }

    @Override
    public List<Movie> getMovieByCategory(String cat) {
        ArrayList<Movie> result=new ArrayList<Movie>();
        for(Movie m:movies){
            String movieCat=m.getMovieCategory().trim();

            if(movieCat.equals(cat.trim())){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List<Movie> getMovieByTitle(String title) {
        ArrayList<Movie> result=new ArrayList<Movie>();
        for(Movie m:movies){
            String movieTitle=m.getMovieTitle().trim();
            movieTitle=movieTitle.toLowerCase();
            title=title.toLowerCase();
            if(movieTitle.contains(title.trim())){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public List<Movie> getMovieByYear(int year) {
        ArrayList<Movie> result=new ArrayList<Movie>();
        for(Movie m:movies){
            int movieYear=m.getMovieYear();

            if(movieYear==year){
                result.add(m);
            }
        }
        return result;
    }
}
