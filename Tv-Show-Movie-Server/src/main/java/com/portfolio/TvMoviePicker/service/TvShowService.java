package com.portfolio.TvMoviePicker.service;


import com.portfolio.TvMoviePicker.dao.SuggesterDao;
import com.portfolio.TvMoviePicker.dao.TvShowDao;
import com.portfolio.TvMoviePicker.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class TvShowService {
    private TvShowDao tvShowDao;
    private SuggesterDao suggesterDao;
    public TvShowService(TvShowDao tvShowDao, SuggesterDao suggesterDao) {
        this.tvShowDao = tvShowDao;
        this.suggesterDao =suggesterDao;
    }

    //search methods
    public List<TvShow> getTvShows(){
        List<TvShow> results = new ArrayList<>();

        results = tvShowDao.getTvShows();
        return results;
    }

    public List<TvShow> getTvShowsBySuggester(String suggesterName){
        List<TvShow> results = new ArrayList<>();

        results = tvShowDao.getTvShowBySuggesterName(suggesterName);
        return results;
    }

    public List<TvShow> getTvShowsByGenre(String genre){
        List<TvShow> results = new ArrayList<>();

        results = tvShowDao.getTvShowByGenre(genre);
        return results;
    }

    public TvShow getTvShowById(int tvShowId){
        TvShow tvShow = null;

        tvShow = tvShowDao.getTvShowById(tvShowId);

        return tvShow;
    }

    //Create Update Delete methods
    public TvShow addTvShow(TvShow newTvShow){
        TvShow tvShow = null;
        tvShow = tvShowDao.createTvShow(newTvShow);

        return tvShow;
    }

    public TvShow updateTvShow(TvShow updatedTvShow){
        TvShow tvShow = null;
        // TvShow existingTvShow = tvShowDao.getTvShowById(updatedTvShoe.getId());
        tvShow = tvShowDao.updateTvShow(updatedTvShow);

        return tvShow;
    }

    public boolean deleteTvShow(int tvShowId){
        boolean tvShowDeleted = false;
        TvShow tvShow = tvShowDao.getTvShowById(tvShowId);

        if (tvShow != null){
            int deleteCount = tvShowDao.deleteTvShowById(tvShowId);
            tvShowDeleted = (deleteCount != 0);
        }
        return tvShowDeleted;
    }

}
