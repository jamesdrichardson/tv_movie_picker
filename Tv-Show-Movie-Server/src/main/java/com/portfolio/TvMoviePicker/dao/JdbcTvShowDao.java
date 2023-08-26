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


    //todo FIXED line 30
    @Override
    public TvShow getTvShowById(int tvShowId) {
       TvShow tvShow = null;

       String sql = "select * from tv_show where tv_show_id = ?";

       try {
           SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tvShowId);
           if (results.next()) {
               tvShow = mapRowToTvShow(results);
           }
       } catch (CannotGetJdbcConnectionException e){
           throw new DaoException("Unable to connect to server...");
       }
       return tvShow;
    }

    @Override
    public List<TvShow> getTvShows() {
        List<TvShow> tvShows = new ArrayList<>();

        String sql = "select * from tv_show order by tv_show_id";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()){
                TvShow tvShow = mapRowToTvShow(results);
                tvShows.add(tvShow);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }
        return tvShows;
    }

    @Override
    public List<TvShow> getTvShowBySuggesterName(String suggesterName) {
        List<TvShow> tvShows = new ArrayList<>();

        String sql = "select * from tv_show where suggester_name = ? order by tv_show_id";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, suggesterName);
            while (results.next()){
                TvShow tvShow = mapRowToTvShow(results);
                tvShows.add(tvShow);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }
        return tvShows;
    }

    @Override
    public List<TvShow> getTvShowByGenre(String genre) {
        List<TvShow> tvShows = new ArrayList<>();

        String sql = "select * from tv_show where tv_show_genre1 = ? or tv_show_genre2 = ? order by tv_show_id";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre, genre);
            while (results.next()){
                TvShow tvShow = mapRowToTvShow(results);
                tvShows.add(tvShow);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }
        return tvShows;
    }

    @Override
    public TvShow createTvShow(TvShow newTvShow) {
        TvShow tvShowToAdd = null;

        // todo to change when i figure out images
        String sql = "insert into tv_show (tv_show_name, tv_show_streaming_service, tv_show_genre1, tv_show_genre2, tv_show_IMBD_rating, tv_show_RT_rating, " +
                "tv_show_description, tv_show_keyword1, tv_show_keyword2, tv_show_keyword3, suggester_name, tv_show_completed, ongoing, episode_count, season_count, " +
                "episode_length, episodes_per_season, day_of_release values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning tv_show_id";

        try {
            int newTvShowId = jdbcTemplate.queryForObject(sql, int.class, newTvShow.getName(), newTvShow.getStreamingService(), newTvShow.getGenre1(),
                    newTvShow.getGenre2(), newTvShow.getImdbRating(), newTvShow.getRtRating(), newTvShow.getDescription(), newTvShow.getKeyword1(),
                    newTvShow.getKeyword2(), newTvShow.getKeyword3(), newTvShow.getSuggesterName(), newTvShow.isCompleted(), newTvShow.isOngoing(), newTvShow.getEpisodeCount(),
                    newTvShow.getSeasonCount(), newTvShow.getEpisodeLength(), newTvShow.getEpisodesPerSeason(), newTvShow.getDayOfRelease());

            tvShowToAdd = getTvShowById(newTvShowId);
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }

        return tvShowToAdd;
    }


    @Override
    public TvShow updateTvShow(TvShow tvShowToUpdate) {
       TvShow tvShow = null;

       String sql = "update tv_show set tv_show_name = ?, tv_show_streaming_service = ?, tv_show_genre1 = ?, tv_show_genre2 = ?, tv_show_IMBD_rating = ?, tv_show_RT_rating = ?, " +
               "tv_show_description = ?, tv_show_keyword1 = ?, tv_show_keyword2 = ?, tv_show_keyword3 = ?, suggester_name = ?, tv_show_completed = ?, ongoing = ?, episode_count = ?, season_count = ?, " +
               "episode_length = ?, episodes_per_season = ?, day_of_release = ?";

       try {
           int rowsAffected = jdbcTemplate.update(sql, tvShowToUpdate.getName(), tvShowToUpdate.getStreamingService(), tvShowToUpdate.getGenre1(),
                   tvShowToUpdate.getGenre2(), tvShowToUpdate.getImdbRating(), tvShowToUpdate.getRtRating(), tvShowToUpdate.getDescription(), tvShowToUpdate.getKeyword1(),
                   tvShowToUpdate.getKeyword2(), tvShowToUpdate.getKeyword3(), tvShowToUpdate.getSuggesterName(), tvShowToUpdate.isCompleted(), tvShowToUpdate.isOngoing(), tvShowToUpdate.getEpisodeCount(),
                   tvShowToUpdate.getSeasonCount(), tvShowToUpdate.getEpisodeLength(), tvShowToUpdate.getEpisodesPerSeason(), tvShowToUpdate.getDayOfRelease());

           if(rowsAffected == 0){
               throw new DaoException("Zero rows affected, expected at least one...");
           }
           tvShow = getTvShowById(tvShowToUpdate.getId());
       }catch (CannotGetJdbcConnectionException e){
           throw new DaoException("Unable to connect to server...");
       }catch (DataIntegrityViolationException e){
           throw new DaoException("Data Integrity Violation", e);
       }
       return tvShow;
    }

    @Override
    public int deleteTvShowById(int tvShowId) {
        int count;

        String sql = "delete from tv_show where tv_show_id = ?";

        try{
            count = jdbcTemplate.update(sql, tvShowId);
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }
        return count;
    }

    private TvShow mapRowToTvShow(SqlRowSet rs){
        TvShow tvShow = new TvShow();

        tvShow.setId(rs.getInt("tv_show_id"));
        tvShow.setName(rs.getString("tv_show_name"));
        tvShow.setStreamingService(rs.getString("tv_show_streaming_service"));
        tvShow.setGenre1(rs.getString("tv_show_genre1"));
        tvShow.setGenre2(rs.getString("tv_show_genre2"));
        tvShow.setImdbRating(rs.getBigDecimal("tv_show_IMDB_rating"));
        tvShow.setRtRating(rs.getInt("tv_show_RT_rating"));
        tvShow.setDescription(rs.getString("tv_show_description"));
        tvShow.setKeyword1(rs.getString("tv_show_keyword1"));
        tvShow.setKeyword2(rs.getString("tv_show_keyword2"));
        tvShow.setKeyword3(rs.getString("tv_show_keyword3"));
        tvShow.setSuggesterName(rs.getString("tv_show_suggester_name"));
        //not sure how to implement this todo ask Jonathan
        //tvShow.setImage(rs.("movie_image"));
        tvShow.setCompleted(rs.getBoolean("tv_show_completed"));
        tvShow.setOngoing(rs.getBoolean("ongoing"));
        tvShow.setEpisodeCount(rs.getInt("episode_count"));
        tvShow.setSeasonCount(rs.getInt("season_count"));
        tvShow.setEpisodeLength(rs.getString("episode_length"));
        tvShow.setEpisodesPerSeason(rs.getString("episodes_per_season"));
        tvShow.setDayOfRelease(rs.getString("day_of_release"));

        return tvShow;
    }


}
