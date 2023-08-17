package com.portfolio.TvShowMovie.sevices;

import com.portfolio.TvShowMovie.model.Movie;

import com.portfolio.TvShowMovie.model.Suggester;
import com.portfolio.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class MovieService {

    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public MovieService(String url){this.API_BASE_URL = url;}
    public void setAuthToken(String authToken){this.authToken = authToken;}

    public List<Movie> getAllMovies(){
        try{
            ResponseEntity<Movie[]> response = restTemplate.exchange(API_BASE_URL + "/movie", HttpMethod.GET, makeAuthEntity(), Movie[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public Movie getMovie(int movieId){
        try {
            ResponseEntity<Movie> response = restTemplate.exchange(String.format("%s/movie/%d",API_BASE_URL,movieId), HttpMethod.GET, makeAuthEntity(), Movie.class);
            return response.getBody();
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public Movie add(Movie newMovie){
        try {
            HttpEntity<Movie> entity = makeMovieEntity(newMovie);
            Movie returnedMovie = restTemplate.postForObject(API_BASE_URL+ "/movie", entity, Movie.class);
            return returnedMovie;
        }catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }


    public boolean delete(int movieId){
        try{
            restTemplate.exchange(String.format("%s/movie/%d",API_BASE_URL,movieId), HttpMethod.DELETE, makeAuthEntity(), Void.class);
            return true;
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return false;
        }
    }

    public Movie update(Movie updatedMovie){
        try{
            HttpEntity<Movie> entity = makeMovieEntity(updatedMovie);
            ResponseEntity<Movie> response = restTemplate.exchange(String.format("%s/movie/%d",API_BASE_URL,updatedMovie.getId()), HttpMethod.PUT, makeAuthEntity(), Movie.class);
            return response.getBody();
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    private HttpEntity<Movie> makeMovieEntity(Movie movie){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(movie, headers);
    }

    private HttpEntity<Void> makeAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
