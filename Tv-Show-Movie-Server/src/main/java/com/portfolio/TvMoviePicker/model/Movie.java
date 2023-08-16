package com.portfolio.TvMoviePicker.model;

import java.awt.*;
import java.math.BigDecimal;

public class Movie {

    int id;
    String name;
    String streamingService;
    String genre1;
    String genre2;
    BigDecimal imdbRating;
    int rtRating;
    String description;
    String keyword1;
    String keyword2;
    String keyword3;
    String suggesterName;
    Image image;
    boolean completed;
    boolean isFree;
    BigDecimal price;
    int runtimeMinutes;
    String director;

    //for creating new movies without id
    public Movie(String name, String streamingService, String genre1, String genre2, BigDecimal imdbRating, int rtRating, String description, String keyword1, String keyword2, String keyword3, String suggesterName, Image image, boolean completed, boolean isFree, BigDecimal price, int runtimeMinutes, String director) {
        this.name = name;
        this.streamingService = streamingService;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.imdbRating = imdbRating;
        this.rtRating = rtRating;
        this.description = description;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.suggesterName = suggesterName;
        this.image = image;
        this.completed = completed;
        this.isFree = isFree;
        this.price = price;
        this.runtimeMinutes = runtimeMinutes;
        this.director = director;
    }

    public Movie(int id, String name, String streamingService, String genre1, String genre2, BigDecimal imdbRating, int rtRating, String description, String keyword1, String keyword2, String keyword3, String suggesterName, Image image, boolean completed, boolean isFree, BigDecimal price, int runtimeMinutes, String director) {
        this.id = id;
        this.name = name;
        this.streamingService = streamingService;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.imdbRating = imdbRating;
        this.rtRating = rtRating;
        this.description = description;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.suggesterName = suggesterName;
        this.image = image;
        this.completed = completed;
        this.isFree = isFree;
        this.price = price;
        this.runtimeMinutes = runtimeMinutes;
        this.director = director;
    }

    //for use with mapping functions
    public Movie() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreamingService() {
        return streamingService;
    }

    public void setStreamingService(String streamingService) {
        this.streamingService = streamingService;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public BigDecimal getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(BigDecimal imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getRtRating() {
        return rtRating;
    }

    public void setRtRating(int rtRating) {
        this.rtRating = rtRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }

    public String getSuggesterName() {
        return suggesterName;
    }

    public void setSuggesterName(String suggesterName) {
        this.suggesterName = suggesterName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(int runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString(){
        return "Movie: " + this.name + "  id: " + this.id;
    }
}
