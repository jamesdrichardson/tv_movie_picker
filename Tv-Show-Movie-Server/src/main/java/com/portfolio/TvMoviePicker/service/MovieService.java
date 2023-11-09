package com.portfolio.TvMoviePicker.service;

import com.portfolio.TvMoviePicker.dao.MovieDao;
import com.portfolio.TvMoviePicker.dao.SuggesterDao;
import com.portfolio.TvMoviePicker.model.movieapi.MovieResults;
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
    public List<MovieResults> getMovies(){
        List<MovieResults> results = new ArrayList<>();

        results = movieDao.getMovies();
        return results;
    }

    public List<MovieResults> getMoviesBySuggester(String suggesterName){
        List<MovieResults> results = new ArrayList<>();

        results = movieDao.getMovieBySuggesterName(suggesterName);
        return results;
    }

    public List<MovieResults> getMoviesByGenre(String genre){
        List<MovieResults> results = new ArrayList<>();

        results = movieDao.getMovieByGenre(genre);
        return results;
    }

    public MovieResults getMovieById(int movieId){
        MovieResults movieResults = null;

        movieResults = movieDao.getMovieById(movieId);

        return movieResults;
    }

    //Create Update Delete methods
    public MovieResults addMovie(MovieResults newMovieResults){
        MovieResults movieResults = null;
        movieResults = movieDao.createMovie(newMovieResults);

        return movieResults;
    }

    public MovieResults updateMovie(MovieResults updatedMovieResults){
        MovieResults movieResults = null;
       // Movie existingMovie = movieDao.getMovieById(updatedMovie.getId());
        movieResults = movieDao.updateMovie(updatedMovieResults);

        return movieResults;
    }

    public boolean deleteMovie(int movieId){
        boolean movieDeleted = false;
        MovieResults movieResults = movieDao.getMovieById(movieId);

        if (movieResults != null){
            int deleteCount = movieDao.deleteMovieById(movieId);
            movieDeleted = (deleteCount != 0);
        }
        return movieDeleted;
    }

}
