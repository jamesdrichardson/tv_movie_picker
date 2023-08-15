package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.model.Movie;

import java.util.List;

public interface MovieDao {

    //gets movie by ID
    Movie getMovieById (int movieId);

    //gets all movies

    List<Movie> getMovies();

    //gets movies by suggester name

    List<Movie> getMovieBySuggesterName(String suggesterName);

    //gets movie by genre can be overloaded in class for genre2
    List<Movie> getMovieByGenre(String genre);

    //gets movie by wildcardsearch using overload?

    //List<Movie> getMovieByWildCard();

    //creates movie
    Movie createMovie(Movie newMovie);
    //updates movie
    Movie updateMovie(Movie movieToUpdate);
    //deletes movie by id
    int deleteMovieById(int movieId);
    //
}
