package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.TvShow;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTvShowDao implements TvShowDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcTvShowDao(DataSource dataSource){jdbcTemplate = new JdbcTemplate(dataSource);}



    private TvShow mapRowToTvShow(SqlRowSet rs){
        TvShow tvShow = new TvShow();

        return tvShow;
    }


    @Override
    public TvShow getTvShowById(int tvShowId) {
        return null;
    }

    @Override
    public List<TvShow> getTvShows() {
        return null;
    }

    @Override
    public List<TvShow> getTvShowBySuggesterName(String suggesterName) {
        return null;
    }

    @Override
    public List<TvShow> getTvShowByGenre(String genre) {
        return null;
    }

    @Override
    public TvShow createTvShow(TvShow newTvShow) {
        return null;
    }

    @Override
    public TvShow updateTvShow(TvShow tvShowToUpdate) {
        return null;
    }

    @Override
    public int deleteTvShowById(int tvShowId) {
        return 0;
    }
}
