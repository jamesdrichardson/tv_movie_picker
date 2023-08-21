package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.exception.DaoException;
import com.portfolio.TvMoviePicker.model.Movie;
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
    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = null;

        String sql = "select * from movie where movie_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, movieId);
            if(results.next()){
                movie = mapRowToMovie(results);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...");
        }
        return movie;
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        String sql = "select * from movie order by movie_id";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()){
                Movie movie = mapRowToMovie(results);
                movies.add(movie);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }
        return movies;
    }

    @Override
    public List<Movie> getMovieBySuggesterName(String suggesterName) {
        List<Movie> movies = new ArrayList<>();

        String sql = "select * from movie where suggester_name = ? order by movie_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, suggesterName);
            while(results.next()){
                Movie movie = mapRowToMovie(results);
                movies.add(movie);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }
        return movies;
    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        List<Movie> movies = new ArrayList<>();
        String sql = "select * from movie where movie_genre1 = ? or movie_genre2 = ? order by movie_id;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre, genre);
            while(results.next()){
                Movie movie = mapRowToMovie(results);
                movies.add(movie);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }
        return movies;
    }

    @Override
    public Movie createMovie(Movie newMovie) {
        Movie movieToAdd = null;

        // todo to change when i figure out images
        String sql = "insert into movie (movie_name, movie_streaming_service, movie_genre1, movie_genre2, movie_IMBD_rating, movie_RT_rating, " +
                "movie_description, movie_keyword1, movie_keyword2, movie_keyword3, suggester_name, movie_completed, is_free, price, runtime_minutes, " +
                "movie_director values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning movie_id";

        try {
            int newMovieId = jdbcTemplate.queryForObject(sql, int.class, newMovie.getName(), newMovie.getStreamingService(), newMovie.getGenre1(),
                    newMovie.getGenre2(), newMovie.getImdbRating(), newMovie.getRtRating(), newMovie.getDescription(), newMovie.getKeyword1(),
                    newMovie.getKeyword2(), newMovie.getKeyword3(), newMovie.getSuggesterName(), newMovie.isCompleted(), newMovie.isFree(), newMovie.getPrice(),
                    newMovie.getRuntimeMinutes(), newMovie.getDirector());

            movieToAdd = getMovieById(newMovieId);
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }

        return movieToAdd;
    }

    @Override
    public Movie updateMovie(Movie movieToUpdate) {
        Movie movie = null;

        String sql = "update movie set movie_name = ?, movie_streaming_service = ?, movie_genre1 = ?, movie_genre2 = ?, movie_IMBD_rating = ?, " +
                "movie_RT_rating = ?, movie_description = ?, movie_keyword1 = ?, movie_keyword2 = ?, movie_keyword3 = ?, suggester_name = ?," +
                " movie_completed = ?, is_free = ?, price = ?, runtime_minutes = ?, movie_director = ?, where movie_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, movieToUpdate.getName(), movieToUpdate.getStreamingService(), movieToUpdate.getGenre1(),
                    movieToUpdate.getGenre2(), movieToUpdate.getImdbRating(), movieToUpdate.getRtRating(), movieToUpdate.getDescription(), movieToUpdate.getKeyword1(),
                    movieToUpdate.getKeyword2(), movieToUpdate.getKeyword3(), movieToUpdate.getSuggesterName(), movieToUpdate.isCompleted(), movieToUpdate.isFree(), movieToUpdate.getPrice(),
                    movieToUpdate.getRuntimeMinutes(), movieToUpdate.getDirector(), movieToUpdate.getId());

            if (rowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one...");
            }
            movie = getMovieById(movieToUpdate.getId());
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...");
        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }
        return movie;
    }

    @Override
    public int deleteMovieById(int movieId) {
        int count;

        String sql = "delete from movie where movie_id = ?";

        try{
            count = jdbcTemplate.update(sql, movieId);
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }
        return count;
    }

    private Movie mapRowToMovie(SqlRowSet rs){
        Movie movie = new Movie();

        movie.setId(rs.getInt("movie_id"));
        movie.setName(rs.getString("movie_name"));
        movie.setStreamingService(rs.getString("movie_streaming_service"));
        movie.setGenre1(rs.getString("movie_genre1"));
        movie.setGenre2(rs.getString("movie_genre2"));
        movie.setImdbRating(rs.getBigDecimal("movie_IMDB_rating"));
        movie.setRtRating(rs.getInt("movie_RT_rating"));
        movie.setDescription(rs.getString("movie_description"));
        movie.setKeyword1(rs.getString("movie_keyword1"));
        movie.setKeyword2(rs.getString("movie_keyword2"));
        movie.setKeyword3(rs.getString("movie_keyword3"));
        movie.setSuggesterName(rs.getString("movie_suggester_name"));
        //not sure how to implement this todo ask Jonathan
        //movie.setImage(rs.("movie_image"));
        movie.setCompleted(rs.getBoolean("movie_completed"));
        movie.setFree(rs.getBoolean("is_free"));
        movie.setPrice(rs.getBigDecimal("price"));
        movie.setRuntimeMinutes(rs.getInt("runtime_minutes"));
        movie.setDirector(rs.getString("movie_director"));

        return movie;
    }
}
