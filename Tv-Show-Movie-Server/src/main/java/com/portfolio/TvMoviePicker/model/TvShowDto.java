package com.portfolio.TvMoviePicker.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TvShowDto {

    List<Map<String,Object>> genres;
    int id;
    boolean in_production;
    Date last_airdate;
    String name;
    List<Map<String,Object>> networks;
    int number_of_episodes;
    int number_of_seasons;
    String overview;
    BigDecimal popularity;
    String poster_path;
    String status;
    BigDecimal vote_average;
    int vote_count;

    //constructors


    public TvShowDto(List<Map<String, Object>> genres, int id, boolean in_production, Date last_airdate, String name, List<Map<String, Object>> networks, int number_of_episodes, int number_of_seasons, String overview, BigDecimal popularity, String poster_path, String status, BigDecimal vote_average, int vote_count) {
        this.genres = genres;
        this.id = id;
        this.in_production = in_production;
        this.last_airdate = last_airdate;
        this.name = name;
        this.networks = networks;
        this.number_of_episodes = number_of_episodes;
        this.number_of_seasons = number_of_seasons;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.status = status;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public TvShowDto() {
    }

    public List<Map<String, Object>> getGenres() {
        return genres;
    }

    public void setGenres(List<Map<String, Object>> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIn_production() {
        return in_production;
    }

    public void setIn_production(boolean in_production) {
        this.in_production = in_production;
    }

    public Date getLast_airdate() {
        return last_airdate;
    }

    public void setLast_airdate(Date last_airdate) {
        this.last_airdate = last_airdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Map<String, Object>> networks) {
        this.networks = networks;
    }

    public int getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(int number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public int getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public void setPopularity(BigDecimal popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getVote_average() {
        return vote_average;
    }

    public void setVote_average(BigDecimal vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "TvShowDto{" +
                "genres=" + genres +
                ", id=" + id +
                ", in_production=" + in_production +
                ", last_airdate=" + last_airdate +
                ", name='" + name + '\'' +
                ", networks=" + networks +
                ", number_of_episodes=" + number_of_episodes +
                ", number_of_seasons=" + number_of_seasons +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", status='" + status + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
