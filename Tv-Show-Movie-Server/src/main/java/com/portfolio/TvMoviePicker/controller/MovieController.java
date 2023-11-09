package com.portfolio.TvMoviePicker.controller;
import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.movieapi.MovieDetail;
import com.portfolio.TvMoviePicker.model.movieapi.MovieResults;
import com.portfolio.TvMoviePicker.service.MovieAPIService;
import com.portfolio.TvMoviePicker.service.MovieService;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping(path = "/movies")
public class MovieController {

    private MovieAPIService movieService;

    public MovieController(MovieAPIService movieService){this.movieService = movieService;}

//    @RequestMapping(method = RequestMethod.GET)
//    public List<MovieResults> getAllMovies(){
//        List<MovieResults> movieResults = new ArrayList<>();
//
//        try{
//            movieResults = movieService.getMovies();
//        } catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//        return movieResults;
//    }
//
//    @RequestMapping(path = "/{suggesterName}", method = RequestMethod.GET)
//    public List<MovieResults> getMoviesBySuggesterName(String suggesterName){
//        List<MovieResults> movieResults = new ArrayList<>();
//
//        try{
//            movieResults = movieService.getMoviesBySuggester(suggesterName);
//        } catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//        return movieResults;
//    }
//
//    //todo how to search both genre fields in this method not sure if hitting both based on path
//    @RequestMapping(path = "/{genre}", method = RequestMethod.GET)
//    public List<MovieResults> getMoviesByGenre(String genre){
//        List<MovieResults> movieResults = new ArrayList<>();
//
//        try{
//            movieResults = movieService.getMoviesBySuggester(genre);
//        } catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//        return movieResults;
//    }

    @RequestMapping(path = "/{movieId}", method = RequestMethod.GET)
    public MovieDetail getMovieById(@PathVariable Integer movieId){
        MovieDetail movieDetail = null;

        try{
            movieDetail = movieService.getMovieDetails(movieId);
            if (movieDetail == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return movieDetail;
    }

//    @ResponseStatus(value = HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST)
//    public MovieResults addMovie(@RequestBody MovieResults newMovieResults){
//        MovieResults movieResults = null;
//
//        try{
//            movieResults = movieService.addMovie(newMovieResults);
//        }catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//
//        return movieResults;
//    }
//
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/{movieId}" , method = RequestMethod.DELETE)
//    public void deleteMovie(@PathVariable int movieId){
//        MovieResults movieResults = null;
//
//        try{
//            if (movieService.deleteMovie(movieId) == false){
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found...");
//            }
//        }catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }

//    @RequestMapping(path = "/{movieId}" , method = RequestMethod.PUT)
//    public Movie updateMovie(@PathVariable int movieId, @RequestBody Movie modifiedMovie){
//        Movie movie = null;
//
//        try{
//            modifiedMovie.setId(movieId);
//            movie = movieService.updateMovie(modifiedMovie);
//            if(movie == null){
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found...");
//            }
//        }catch (DaoException e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//        return movie;
//    }
}
