package com.portfolio.Side.Project.model;

import java.awt.*;
import java.math.BigDecimal;

public class TvShow {

    int id;
    String name;
    String streamingService;
    String genre1;
    String genre2;
    int imbdRating;
    int rtRating;
    String description;
    String keyword1;
    String keyword2;
    String keyword3;
    String suggesterName;
    Image image;
    boolean completed;
    boolean ongoing;
    int episode_count;
    int season_count;
    String episodeLength;
    String episodesPerSeason;
    String dayOfRelease;

    //for creating new tvShows without id


    public TvShow(String name, String streamingService, String genre1, String genre2, int imbdRating, int rtRating, String description, String keyword1, String keyword2, String keyword3, String suggesterName, Image image, boolean completed, boolean ongoing, int episode_count, int season_count, String episodeLength, String episodesPerSeason, String dayOfRelease) {
        this.name = name;
        this.streamingService = streamingService;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.imbdRating = imbdRating;
        this.rtRating = rtRating;
        this.description = description;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.suggesterName = suggesterName;
        this.image = image;
        this.completed = completed;
        this.ongoing = ongoing;
        this.episode_count = episode_count;
        this.season_count = season_count;
        this.episodeLength = episodeLength;
        this.episodesPerSeason = episodesPerSeason;
        this.dayOfRelease = dayOfRelease;
    }

    public TvShow(int id, String name, String streamingService, String genre1, String genre2, int imbdRating, int rtRating, String description, String keyword1, String keyword2, String keyword3, String suggesterName, Image image, boolean completed, boolean ongoing, int episode_count, int season_count, String episodeLength, String episodesPerSeason, String dayOfRelease) {
        this.id = id;
        this.name = name;
        this.streamingService = streamingService;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.imbdRating = imbdRating;
        this.rtRating = rtRating;
        this.description = description;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.suggesterName = suggesterName;
        this.image = image;
        this.completed = completed;
        this.ongoing = ongoing;
        this.episode_count = episode_count;
        this.season_count = season_count;
        this.episodeLength = episodeLength;
        this.episodesPerSeason = episodesPerSeason;
        this.dayOfRelease = dayOfRelease;
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

    public int getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(int imbdRating) {
        this.imbdRating = imbdRating;
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

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public int getSeason_count() {
        return season_count;
    }

    public void setSeason_count(int season_count) {
        this.season_count = season_count;
    }

    public String getEpisodeLength() {
        return episodeLength;
    }

    public void setEpisodeLength(String episodeLength) {
        this.episodeLength = episodeLength;
    }

    public String getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(String episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public String getDayOfRelease() {
        return dayOfRelease;
    }

    public void setDayOfRelease(String dayOfRelease) {
        this.dayOfRelease = dayOfRelease;
    }

    @Override
    public String toString(){
        return "Tv Show: " + this.name + "  id: " + this.id;
    }
}
