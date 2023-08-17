package com.portfolio.TvShowMovie.sevices;

import com.portfolio.TvShowMovie.model.Suggester;
import com.portfolio.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SuggesterService {
    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();

    public SuggesterService(String url) {this.API_BASE_URL = url;}

    public List<Suggester> getAllSuggesters(){
        try {
            Suggester[] response = restTemplate.getForObject(API_BASE_URL + "suggesters", Suggester[].class);
            return Arrays.asList(response);
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    //todo ask Jonathan how to create
    public Suggester add(Suggester newSuggester){
        try {
            HttpEntity<Suggester> entity = makeSuggesterEntity(newSuggester);
            Suggester returnedSuggester = restTemplate.postForObject(API_BASE_URL+ "suggesters", entity, Suggester.class);
            return returnedSuggester;
        }catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }
    public Suggester getSuggester(String suggesterName){
        try {
            Suggester response = restTemplate.getForObject(API_BASE_URL + "suggesters", Suggester.class );
            return response;
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public boolean delete(String suggesterName){
        try{
            restTemplate.delete(API_BASE_URL, suggesterName , HttpMethod.DELETE, Void.class);
            return true;
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return false;
        }
    }

    public Suggester update(Suggester updatedSuggester){
        try{
            HttpEntity<Suggester> entity = makeSuggesterEntity(updatedSuggester);
            Suggester response = restTemplate.getForObject(API_BASE_URL + "/suggesters", Suggester.class);
            return response;
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    private HttpEntity<Suggester> makeSuggesterEntity(Suggester suggester){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(suggester, headers);
    }
}
