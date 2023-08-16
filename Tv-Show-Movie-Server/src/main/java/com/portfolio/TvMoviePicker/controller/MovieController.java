package com.portfolio.TvMoviePicker.controller;
import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.Movie;
import com.portfolio.TvMoviePicker.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){this.movieService = movieService;}

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();

        try{
            movies = movieService.getMovies();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return movies;
    }

    @RequestMapping(path = "/{suggesterName}", method = RequestMethod.GET)
    public List<Movie> getMoviesBySuggesterName(String suggesterName){
        List<Movie> movies = new ArrayList<>();

        try{
            movies = movieService.getMoviesBySuggester(suggesterName);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return movies;
    }

    //todo how to search both genre fields in this method not sure if hitting both based on path
    @RequestMapping(path = "/{genre}", method = RequestMethod.GET)
    public List<Movie> getMoviesByGenre(String genre){
        List<Movie> movies = new ArrayList<>();

        try{
            movies = movieService.getMoviesBySuggester(genre);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return movies;
    }

    @RequestMapping(path = "/{movieId}", method = RequestMethod.GET)
    public Movie getMovieById(int movieId){
        Movie movie = null;

        try{
            movie = movieService.getMovieById(movieId);
            if (movie == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return movie;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie newMovie){
        Movie movie = null;

        try{
            movie = movieService.addMovie(newMovie);
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return movie;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{movieId}" , method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable int movieId){
        Movie movie = null;

        try{
            if (movieService.deleteMovie(movieId) == false){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(path = "/{movieId}" , method = RequestMethod.PUT)
    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie modifiedMovie){
        Movie movie = null;

        try{
            modifiedMovie.setId(movieId);
            movie = movieService.updateMovie(modifiedMovie);
            if(movie == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return movie;
    }
}
