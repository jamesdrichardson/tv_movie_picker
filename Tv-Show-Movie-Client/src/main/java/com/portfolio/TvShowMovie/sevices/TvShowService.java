package com.portfolio.TvShowMovie.sevices;


import com.portfolio.TvShowMovie.model.TvShow;
import com.portfolio.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class TvShowService {
    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public TvShowService(String url){this.API_BASE_URL = url;}
    public void setAuthToken(String authToken){this.authToken = authToken;}

    public List<TvShow> getAllTvShows(){
        try{
            ResponseEntity<TvShow[]> response = restTemplate.exchange(API_BASE_URL + "/tvshow", HttpMethod.GET, makeAuthEntity(), TvShow[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public TvShow getTvShow(int tvShowId){
        try {
            ResponseEntity<TvShow> response = restTemplate.exchange(String.format("%s/tvshow/%d",API_BASE_URL,tvShowId), HttpMethod.GET, makeAuthEntity(), TvShow.class);
            return response.getBody();
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public TvShow add(TvShow newTvShow){
        try {
            HttpEntity<TvShow> entity = makeMovieEntity(newTvShow);
            TvShow returnedTvShow = restTemplate.postForObject(API_BASE_URL+ "/tvshow", entity, TvShow.class);
            return returnedTvShow;
        }catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }


    public boolean delete(int tvShowId){
        try{
            restTemplate.exchange(String.format("%s/tvshow/%d",API_BASE_URL,tvShowId), HttpMethod.DELETE, makeAuthEntity(), Void.class);
            return true;
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return false;
        }
    }

    public TvShow update(TvShow updatedTvShow){
        try{
            HttpEntity<TvShow> entity = makeMovieEntity(updatedTvShow);
            ResponseEntity<TvShow> response = restTemplate.exchange(String.format("%s/tvshow/%d",API_BASE_URL,updatedTvShow.getId()), HttpMethod.PUT, makeAuthEntity(), TvShow.class);
            return response.getBody();
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    private HttpEntity<TvShow> makeMovieEntity(TvShow tvShow){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(tvShow, headers);
    }

    private HttpEntity<Void> makeAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
