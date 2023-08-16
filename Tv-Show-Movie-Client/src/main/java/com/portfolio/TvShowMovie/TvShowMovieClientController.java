package com.portfolio.TvShowMovie;

import com.portfolio.TvShowMovie.model.Movie;
import com.portfolio.util.BasicConsole;
import com.portfolio.util.BasicLogger;

import java.awt.*;

public class TvShowMovieClientController {

    private final TvShowMovieClientView view;
    //todo add api service variables

    public TvShowMovieClientController (BasicConsole console){
        view = new TvShowMovieClientView(console);
        //todo add api service variables
    }

    public void run() {
        try {
            final String PICK_MOVIES = "Let's choose a movie to watch!";
            final String PICK_TV_SHOWS = "Let's choose a TV show to watch!";
            final String SUGGESTER_CONTROLS = "Add / Modify / Delete people who have suggested things for us to watch.";
            final String EXIT = "Exit application";
            final String[] MAIN_MENU_OPTIONS = {PICK_MOVIES,PICK_TV_SHOWS,SUGGESTER_CONTROLS,EXIT};

            view.displayWelcomeMessage();

            boolean finished = false;

            while(!finished){
                String mainMenuSelection = view.selectFromMenu("Main Menu", MAIN_MENU_OPTIONS);
                switch (mainMenuSelection) {
                    case PICK_MOVIES:
                        showMovieSubmenu();
                        break;
                    case PICK_TV_SHOWS:
                        showTvShowSubmenu();
                        break;
                    case SUGGESTER_CONTROLS:
                        showSuggesterSubmenu();
                        break;
                    case EXIT:
                        finished = true;
                        break;
                }
            }
        }catch (Exception e){
            view.displayErrorMessage("An unexpected error has occurred. See log file for details.");
            BasicLogger.log(e);
        }
    }

    private void showMovieSubmenu(){

        final String MOVIE_SEARCH = "What should I watch today?";
        final String ADD_MOVIE = "Let's add a movie to the watch list!";
        final String UPDATE_MOVIE = "Let's update a movie already in the list!";
        final String DELETE_MOVIE = "If you're really sure you want to mess with your records, you could delete a movie...";
        final String BACK = "Back to main menu.";
        final String[] MOVIE_OPTIONS = {MOVIE_SEARCH,ADD_MOVIE,UPDATE_MOVIE,DELETE_MOVIE,BACK};



        boolean showSubmenu = true;
        while (showSubmenu){
            String subMenuSelection = view.selectFromMenu("Movie Menu", MOVIE_OPTIONS);

            switch (subMenuSelection) {
                case MOVIE_SEARCH:
                    movieSearch();
                    break;
                case ADD_MOVIE:
                    //todo how to add movies without api calls
                    break;
                case UPDATE_MOVIE:
                    //todo how to update movies without api calls
                    break;
                case DELETE_MOVIE:
                    //todo how to delete movies without api calls
                    break;
                case BACK:
                    showSubmenu = false;
                    break;

            }
        }
    }

    public void movieSearch(){

        final String SEARCH_BY_SUGGESTER = "Search by who suggested the movie.";
        final String SEARCH_BY_GENRE = "Search by genre.";
        final String RETURN_ALL_MOVIES = "Show all available movies";
        final String PICK_RANDOM_MOVIE = "Surprise me!";
        final String BACK = "Return to Movie Menu.";
        final String[] MOVIE_SEARCH_OPTIONS = {SEARCH_BY_SUGGESTER,SEARCH_BY_GENRE,RETURN_ALL_MOVIES,PICK_RANDOM_MOVIE,BACK};

        boolean showSubmenu = true;

        while (showSubmenu){
            String subMenuSelection = view.selectFromMenu("Movie Search Menu", MOVIE_SEARCH_OPTIONS);

            switch (subMenuSelection) {
                case SEARCH_BY_SUGGESTER:
                    //todo how to add movies without api calls
                    break;
                case SEARCH_BY_GENRE:
                    //todo how to add movies without api calls
                    break;
                case RETURN_ALL_MOVIES:
                    //todo how to update movies without api calls
                    break;
                case PICK_RANDOM_MOVIE:
                    //todo how to delete movies without api calls
                    break;
                case BACK:
                    showSubmenu = false;
                    break;

            }
        }
    }

    private void showTvShowSubmenu(){

        final String TV_SHOW_SEARCH = "What should I watch today?";
        final String ADD_TV_SHOW = "Let's add a TV show to the watch list!";
        final String UPDATE_TV_SHOW = "Let's update a TV show already in the list!";
        final String DELETE_TV_SHOW = "If you're really sure you want to mess with your records, you could delete a Tv show...";
        final String BACK = "Back to main menu.";
        final String[] TV_SHOW_OPTIONS = {TV_SHOW_SEARCH,ADD_TV_SHOW,UPDATE_TV_SHOW,DELETE_TV_SHOW,BACK};



        boolean showSubmenu = true;
        while (showSubmenu){
            String subMenuSelection = view.selectFromMenu("TV Show Menu", TV_SHOW_OPTIONS);

            switch (subMenuSelection) {
                case TV_SHOW_SEARCH:
                    tvShowSearch();
                    break;
                case ADD_TV_SHOW:
                    //todo how to add movies without api calls
                    break;
                case UPDATE_TV_SHOW:
                    //todo how to update movies without api calls
                    break;
                case DELETE_TV_SHOW:
                    //todo how to delete movies without api calls
                    break;
                case BACK:
                    showSubmenu = false;
                    break;

            }
        }
    }

    public void tvShowSearch(){

        final String SEARCH_BY_SUGGESTER = "Search by who suggested the show.";
        final String SEARCH_BY_GENRE = "Search by genre.";
        final String RETURN_ALL_MOVIES = "Show all available TV shows";
        final String PICK_RANDOM_MOVIE = "Surprise me!";
        final String BACK = "Return to TV show Menu.";
        final String[] TV_SHOW_SEARCH_OPTIONS = {SEARCH_BY_SUGGESTER,SEARCH_BY_GENRE,RETURN_ALL_MOVIES,PICK_RANDOM_MOVIE,BACK};

        boolean showSubmenu = true;

        while (showSubmenu){
            String subMenuSelection = view.selectFromMenu("TV Show Search Menu", TV_SHOW_SEARCH_OPTIONS);

            switch (subMenuSelection) {
                case SEARCH_BY_SUGGESTER:
                    //todo how to add movies without api calls
                    break;
                case SEARCH_BY_GENRE:
                    //todo how to add movies without api calls
                    break;
                case RETURN_ALL_MOVIES:
                    //todo how to update movies without api calls
                    break;
                case PICK_RANDOM_MOVIE:
                    //todo how to delete movies without api calls
                    break;
                case BACK:
                    showSubmenu = false;
                    break;

            }
        }
    }

    private void showSuggesterSubmenu(){

        final String ADD_SUGGESTER = "Add a new Suggester";
        final String UPDATE_SUGGESTER = "Update a previous Suggester";
        final String DELETE_SUGGESTER = "Remove a Suggester from the list (though you really shouldn't do that for history's sake).";
        final String VIEW_ALL_SUGGESTERS = "View all Suggesters";
        final String BACK = "Back to main menu.";
        final String[] SUGGESTER_OPTIONS = {ADD_SUGGESTER,UPDATE_SUGGESTER,DELETE_SUGGESTER,VIEW_ALL_SUGGESTERS,BACK};



        boolean showSubmenu = true;
        while (showSubmenu){
            String subMenuSelection = view.selectFromMenu("Suggester Menu", SUGGESTER_OPTIONS);

            switch (subMenuSelection) {
                case ADD_SUGGESTER:
                    //todo how to add suggesters without api calls
                    break;
                case UPDATE_SUGGESTER:
                    //todo how to update suggesters without api calls
                    break;
                case DELETE_SUGGESTER:
                    //todo how to delete suggesters without api calls
                    break;
                case VIEW_ALL_SUGGESTERS:
                    //todo how to view all suggesters without api calls
                    break;
                case BACK:
                    showSubmenu = false;
                    break;

            }
        }
    }

    public void addMovie(){}
    public void updateMovie(){}
    public void deleteMovie(){}
    public void addTvShow(){}
    public void updateTvShow(){}
    public void deleteTvShow(){}
    public void addSuggester(){}
    public void updateSuggester(){}
    public void deleteSuggester(){}

    //probably need some helper methods for searching todo ask Jonathan about these

}
