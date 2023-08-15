package com.portfolio.TvMoviePicker.dao;

import com.portfolio.TvMoviePicker.model.Suggester;

public interface SuggesterDao {
    Suggester getSuggesterByName(String suggesterName);

    Suggester createSuggester(Suggester suggester);

    int deleteSuggesterByName(String suggesterName);

    Suggester updateSuggesterName (Suggester updatedSuggester);
}
