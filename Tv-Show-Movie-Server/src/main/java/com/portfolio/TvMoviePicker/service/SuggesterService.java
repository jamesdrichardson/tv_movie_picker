package com.portfolio.TvMoviePicker.service;
import com.portfolio.TvMoviePicker.dao.SuggesterDao;
import com.portfolio.TvMoviePicker.model.Suggester;



import java.util.ArrayList;
import java.util.List;

public class SuggesterService {
    private SuggesterDao suggesterDao;

    public SuggesterService(SuggesterDao suggesterDao){this.suggesterDao = suggesterDao;}

    public List<Suggester> getSuggesters(){
        List<Suggester> results = new ArrayList<>();

        results = suggesterDao.getSuggesters();
        return results;
    }

    public Suggester addSuggester(Suggester newSuggester){
        Suggester suggester = null;
        suggester = suggesterDao.createSuggester(newSuggester);

        return suggester;
    }

    public Suggester updateSuggester(Suggester updatedSuggester){
        Suggester suggester = null;
        // TvShow existingTvShow = tvShowDao.getTvShowById(updatedTvShoe.getId());
        suggester = suggesterDao.updateSuggesterName(updatedSuggester);

        return suggester;
    }

    public boolean deleteSuggester(String suggesterName){
        boolean suggesterDeleted = false;
        Suggester suggester = suggesterDao.getSuggesterByName(suggesterName);

        if (suggester != null){
            int deleteCount = suggesterDao.deleteSuggesterByName(suggesterName);
            suggesterDeleted = (deleteCount != 0);
        }
        return suggesterDeleted;
    }

    public Suggester getSuggesterByName(String suggesterName){
        Suggester suggester = null;

        suggester = suggesterDao.getSuggesterByName(suggesterName);

        return suggester;
    }
}
