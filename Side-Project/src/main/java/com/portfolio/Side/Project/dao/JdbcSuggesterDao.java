package com.portfolio.Side.Project.dao;

import com.portfolio.Side.Project.exception.DaoException;
import com.portfolio.Side.Project.model.Suggester;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcSuggesterDao implements SuggesterDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSuggesterDao(DataSource dataSource){jdbcTemplate = new JdbcTemplate(dataSource);}


    @Override
    public Suggester getSuggesterByName(String suggesterName) {
        Suggester suggester = null;

        String sql = "select suggester_name from suggester where suggester_name = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, suggesterName);
            if (results.next()){
                suggester = mapRowToSuggester(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...");
        }

        return suggester;
    }

    @Override
    public Suggester createSuggester(Suggester suggester) {
        Suggester newSuggester = null;

        String sql = "insert into suggester (suggester_name) values (?)";

        try {
            String newTestSuggester = jdbcTemplate.queryForObject(sql, String.class, suggester);
            newSuggester = getSuggesterByName(newTestSuggester);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }

        return newSuggester;
    }

    @Override
    public int deleteSuggesterByName(String suggesterName) {
        int count;

        String sql = "delete from suggester where suggester_name=?;";

        String sqlMov = "delete from movie where suggester_name=?;";
        String sqlTvs = "delete from tv_show where suggester_name=?;";

        try {
            jdbcTemplate.update(sqlMov, suggesterName);
            jdbcTemplate.update(sqlTvs, suggesterName);
            count = jdbcTemplate.update(sql, suggesterName);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }
        return count;
    }

    @Override
    public Suggester updateSuggesterName(Suggester updatedSuggester) {
        Suggester suggester = null;

        String suggesterName = updatedSuggester.getSuggesterName();

        String sql = "update suggester set suggester_name=? where suggester_name=?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, suggesterName, updatedSuggester.getSuggesterName());
            if (rowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one...");
            }
            suggester = getSuggesterByName(updatedSuggester.getSuggesterName());
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server...");
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity Violation", e);
        }

        return suggester;
    }

    private Suggester mapRowToSuggester(SqlRowSet rs){
        Suggester suggester = new Suggester();

        suggester.setSuggesterName(rs.getString("suggester"));

        return suggester;
    }
}
