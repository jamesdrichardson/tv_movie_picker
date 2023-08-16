package com.portfolio.TvMoviePicker.controller;

import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.Suggester;
import com.portfolio.TvMoviePicker.service.SuggesterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/suggesters")
public class SuggesterController {
    private SuggesterService suggesterService;

    public SuggesterController(SuggesterService suggesterService){this.suggesterService = suggesterService;}

    @RequestMapping(method = RequestMethod.GET)
    public List<Suggester> getAllSuggesters(){
        List<Suggester> suggesters = new ArrayList<>();

        try{
            suggesters = suggesterService.getSuggesters();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return suggesters;
    }

    @RequestMapping(path = "/{suggesterName}", method = RequestMethod.GET)
    public Suggester getSuggesterByName(String suggesterName){
        Suggester suggester = null;

        try{
            suggester = suggesterService.getSuggesterByName(suggesterName);
            if (suggester == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suggester not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return suggester;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Suggester addSuggester(@RequestBody Suggester newSuggester){
        Suggester suggester = null;

        try{
            suggester = suggesterService.addSuggester(newSuggester );
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return suggester;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{suggesterName}" , method = RequestMethod.DELETE)
    public void deleteSuggester(@PathVariable String suggesterName){
        Suggester tvShow = null;

        try{
            if (suggesterService.deleteSuggester(suggesterName) == false){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suggester not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(path = "/{suggesterName}" , method = RequestMethod.PUT)
    public Suggester updateSuggester(@PathVariable String suggesterName, @RequestBody Suggester modifiedSuggester){
        Suggester suggester = null;

        try{
            modifiedSuggester.setSuggesterName(suggesterName);
            suggester = suggesterService.updateSuggester(modifiedSuggester);
            if(suggester == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suggester not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return suggester;
    }


}
