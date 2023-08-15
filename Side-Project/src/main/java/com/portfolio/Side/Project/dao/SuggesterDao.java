package com.portfolio.Side.Project.dao;

import com.portfolio.Side.Project.model.Suggester;

public interface SuggesterDao {
    Suggester getSuggesterByName(String suggesterName);

    Suggester createSuggester(Suggester suggester);

    int deleteSuggesterByName(String suggesterName);

    Suggester updateSuggesterName (Suggester updatedSuggester);
}
