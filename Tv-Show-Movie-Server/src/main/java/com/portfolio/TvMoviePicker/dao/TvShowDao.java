package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.model.TvShow;

import java.util.List;

public interface TvShowDao {
    //gets TvShow by ID
    TvShow getTvShowById (int tvShowId);

    //gets all TvShow

    List<TvShow> getTvShows();

    //gets TvShow by suggester name

    List<TvShow> getTvShowBySuggesterName(String suggesterName);

    //gets TvShow by genre can be overloaded in class for genre2? maybe using sql statement instead of overloading?
    List<TvShow> getTvShowByGenre(String genre);

    //gets TvShow by wildcardsearch using overload?

    //List<TvShow> getTvShowByWildCard();

    //creates TvShow
    TvShow createTvShow(TvShow newTvShow);
    //updates TvShow
    TvShow updateTvShow(TvShow tvShowToUpdate);
    //deletes TvShow by id
    int deleteTvShowById(int tvShowId);
    //
}
