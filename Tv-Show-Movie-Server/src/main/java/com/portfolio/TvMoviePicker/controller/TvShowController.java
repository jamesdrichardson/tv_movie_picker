package com.portfolio.TvMoviePicker.controller;

import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.TvShow;
import com.portfolio.TvMoviePicker.service.TvShowService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/tvShows")
//@PreAuthorize("permitALl()")
public class TvShowController {
    private TvShowService tvShowService;

    public TvShowController(TvShowService tvShowService){this.tvShowService = tvShowService;}

    @RequestMapping(method = RequestMethod.GET)
    public List<TvShow> getAllTvShows(){
        List<TvShow> tvShows = new ArrayList<>();

        try{
            tvShows = tvShowService.getTvShows();
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return tvShows;
    }


    //todo FIXED request mapping and path variable
    @RequestMapping(path = "/suggesterName/{suggesterName}", method = RequestMethod.GET)
    public List<TvShow> getTvShowsBySuggesterName(@PathVariable String suggesterName){
        List<TvShow> tvShows = new ArrayList<>();

        try{
            tvShows = tvShowService.getTvShowsBySuggester(suggesterName);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return tvShows;
    }
    //todo FIXED request mapping and path variable
    //todo FIXED how to search both genre fields in this method not sure if hitting both based on path
    @RequestMapping(path = "/genre1/{genre}", method = RequestMethod.GET)
    public List<TvShow> getTvShowsByGenre(@PathVariable String genre){
        List<TvShow> tvShows = new ArrayList<>();

        try{
            tvShows = tvShowService.getTvShowsByGenre(genre);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return tvShows;
    }


    //todo FIXED line 62 added path variable
    @RequestMapping(path = "/{tvShowId}", method = RequestMethod.GET)
    public TvShow getTvShowById(@PathVariable int tvShowId){
        TvShow tvShow = null;

        try{
            tvShow = tvShowService.getTvShowById(tvShowId);
            if (tvShow == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TV show not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return tvShow;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public TvShow addTvShow(@RequestBody TvShow newTvShow){
        TvShow tvShow = null;

        try{
            tvShow = tvShowService.addTvShow(newTvShow);
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return tvShow;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{tvShowId}" , method = RequestMethod.DELETE)
    public void deleteTvShow(@PathVariable int tvShowId){
        TvShow tvShow = null;

        try{
            if (tvShowService.deleteTvShow(tvShowId) == false){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TV show not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @RequestMapping(path = "/{tvShowId}" , method = RequestMethod.PUT)
    public TvShow updateTvShow(@PathVariable int tvShowId, @RequestBody TvShow modifiedTvShow){
        TvShow tvShow = null;

        try{
            modifiedTvShow.setId(tvShowId);
            tvShow = tvShowService.updateTvShow(modifiedTvShow);
            if(tvShow == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TV show not found...");
            }
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return tvShow;
    }
}
