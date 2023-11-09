package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.model.movieapi.MovieResults;

import java.util.List;

public interface MovieDao {

    //gets movie by ID
    MovieResults getMovieById (int movieId);

    //gets all movies

    List<MovieResults> getMovies();

    //gets movies by suggester name

    List<MovieResults> getMovieBySuggesterName(String suggesterName);

    //gets movie by genre can be overloaded in class for genre2
    List<MovieResults> getMovieByGenre(String genre);

    //gets movie by wildcardsearch using overload?

    //List<Movie> getMovieByWildCard();

    //creates movie
    MovieResults createMovie(MovieResults newMovieResults);
    //updates movie
    MovieResults updateMovie(MovieResults movieResultsToUpdate);
    //deletes movie by id
    int deleteMovieById(int movieId);
    //
}
