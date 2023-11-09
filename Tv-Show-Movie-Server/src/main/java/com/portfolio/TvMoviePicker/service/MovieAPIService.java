package com.portfolio.TvMoviePicker.service;

import com.portfolio.TvMoviePicker.model.movieapi.MovieDetail;
import com.portfolio.TvMoviePicker.model.movieapi.MovieResults;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieAPIService {


    RestTemplate restTemplate = new RestTemplate();
    private final String API_KEY = "438c573f965dabf3f35c68830bc78c1c";
    public MovieResults getPopularMovies() throws ResourceAccessException{

        MovieResults movieResults = null;
        movieResults = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY, MovieResults.class);

        return movieResults;
    }

    public MovieDetail getMovieDetails(Integer id) {

        MovieDetail movieDetail = null;
        movieDetail = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+id+"?api_key="+API_KEY, MovieDetail.class);

        return movieDetail;
    }

}
