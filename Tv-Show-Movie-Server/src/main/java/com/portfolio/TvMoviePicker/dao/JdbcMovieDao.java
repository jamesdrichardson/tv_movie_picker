package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.movieapi.MovieResults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource){jdbcTemplate = new JdbcTemplate(dataSource);}


    private MovieResults mapRowToMovie(SqlRowSet rs){
        MovieResults movieResults = new MovieResults();

        return movieResults;
    }

    @Override
    public MovieResults getMovieById(int movieId) {
        return null;
    }

    @Override
    public List<MovieResults> getMovies() {
        return null;
    }

    @Override
    public List<MovieResults> getMovieBySuggesterName(String suggesterName) {
        return null;
    }

    @Override
    public List<MovieResults> getMovieByGenre(String genre) {
        return null;
    }

    @Override
    public MovieResults createMovie(MovieResults newMovieResults) {
        return null;
    }

    @Override
    public MovieResults updateMovie(MovieResults movieResultsToUpdate) {
        return null;
    }

    @Override
    public int deleteMovieById(int movieId) {
        return 0;
    }
}
