package com.portfolio.TvMoviePicker.service;

import com.portfolio.TvMoviePicker.dao.MovieDao;
import com.portfolio.TvMoviePicker.dao.SuggesterDao;
import com.portfolio.TvMoviePicker.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieService {

    private MovieDao movieDao;
    private SuggesterDao suggesterDao;
    public MovieService(MovieDao movieDao, SuggesterDao suggesterDao) {
        this.movieDao = movieDao;
        this.suggesterDao =suggesterDao;
    }

    //search methods
    public List<Movie> getMovies(){
        List<Movie> results = new ArrayList<>();

        results = movieDao.getMovies();
        return results;
    }

    public List<Movie> getMoviesBySuggester(String suggesterName){
        List<Movie> results = new ArrayList<>();

        results = movieDao.getMovieBySuggesterName(suggesterName);
        return results;
    }

    public List<Movie> getMoviesByGenre(String genre){
        List<Movie> results = new ArrayList<>();

        results = movieDao.getMovieByGenre(genre);
        return results;
    }

    public Movie getMovieById(int movieId){
        Movie movie = null;

        movie = movieDao.getMovieById(movieId);

        return movie;
    }

    //Create Update Delete methods
    public Movie addMovie(Movie newMovie){
        Movie movie = null;
        movie = movieDao.createMovie(newMovie);

        return movie;
    }

    public Movie updateMovie(Movie updatedMovie){
        Movie movie = null;
       // Movie existingMovie = movieDao.getMovieById(updatedMovie.getId());
        movie = movieDao.updateMovie(updatedMovie);

        return movie;
    }

    public boolean deleteMovie(int movieId){
        boolean movieDeleted = false;
        Movie movie = movieDao.getMovieById(movieId);

        if (movie != null){
            int deleteCount = movieDao.deleteMovieById(movieId);
            movieDeleted = (deleteCount != 0);
        }
        return movieDeleted;
    }

}
