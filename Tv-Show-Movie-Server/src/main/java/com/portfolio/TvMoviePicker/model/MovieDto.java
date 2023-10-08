package com.portfolio.TvMoviePicker.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MovieDto {

    List<Map<String,Object>> genres;
    int id;
    String title;
    String overview;
    BigDecimal popularity;
    String poster_path;
    Date release_date;
    int runtime;
    String status;
    BigDecimal vote_average;
    int vote_count;

    public MovieDto(List<Map<String, Object>> genres, int id, String title, String overview, BigDecimal popularity, String poster_path, Date release_date, int runtime, String status, BigDecimal vote_average, int vote_count) {
        this.genres = genres;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.runtime = runtime;
        this.status = status;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public MovieDto() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
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
        return "MovieDto{" +
                "genres=" + genres +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", release_date=" + release_date +
                ", runtime=" + runtime + " minutes" +
                ", status='" + status + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
