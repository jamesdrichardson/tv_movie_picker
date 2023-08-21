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

    private String authToken = null;

    public SuggesterService(String url) {this.API_BASE_URL = url;}
    public void setAuthToken(String authToken){this.authToken = authToken;}

    public List<Suggester> getAllSuggesters(){
        try {
            ResponseEntity<Suggester[]> response = restTemplate.exchange(API_BASE_URL + "/suggesters", HttpMethod.GET, makeAuthEntity(), Suggester[].class);
            //Suggester[] response = restTemplate.getForObject(API_BASE_URL + "/suggester", Suggester[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public Suggester getSuggester(String suggesterName){
        try {
            ResponseEntity<Suggester> response = restTemplate.exchange(String.format("%s/suggesters/%s",API_BASE_URL,suggesterName), HttpMethod.GET, makeAuthEntity(), Suggester.class);
            //Suggester response = getForObject(API_BASE_URL + "/suggester", Suggester.class );
            return response.getBody();
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public Suggester add(Suggester newSuggester){
        try {
            HttpEntity<Suggester> entity = makeSuggesterEntity(newSuggester);
            Suggester returnedSuggester = restTemplate.postForObject(API_BASE_URL+ "/suggesters", entity, Suggester.class);
            return returnedSuggester;
        }catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return null;
        }
    }


    public boolean delete(String suggesterName){
        try{
            restTemplate.exchange(String.format("%s/suggesters/%s",API_BASE_URL,suggesterName), HttpMethod.DELETE, makeAuthEntity(), Void.class);
            return true;
        } catch (RestClientException e){
            BasicLogger.log(e.getMessage());
            return false;
        }
    }

    public Suggester update(Suggester updatedSuggester){
        try{
            HttpEntity<Suggester> entity = makeSuggesterEntity(updatedSuggester);
            ResponseEntity<Suggester> response = restTemplate.exchange(String.format("%s/suggesters/%s",API_BASE_URL,updatedSuggester.getSuggesterName()), HttpMethod.PUT, makeAuthEntity(), Suggester.class);
//            Suggester response = restTemplate.getForObject(API_BASE_URL + "/suggester", Suggester.class);
            return response.getBody();
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

    private HttpEntity<Void> makeAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
