package com.portfolio.TvMoviePicker.model;

public class Suggester {

    public String suggesterName;

    public Suggester(String suggesterName) {
        this.suggesterName = suggesterName;
    }

    public Suggester(){}

    public String getSuggesterName() {
        return suggesterName;
    }

    public void setSuggesterName(String suggesterName) {
        this.suggesterName = suggesterName;
    }

    @Override
    public String toString(){
        return "Suggester Name: " + this.suggesterName;
    }
}


