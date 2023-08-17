//todo ask Jonathan how/ why this works
package com.portfolio.TvShowMovie;

import com.portfolio.TvShowMovie.model.Movie;
import com.portfolio.TvShowMovie.model.Suggester;
import com.portfolio.TvShowMovie.model.TvShow;
import com.portfolio.util.BasicConsole;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TvShowMovieClientView {
    private final String FOREGROUND_DEFAULT = (char) 27 + "[39m";
    private final String FOREGROUND_RED = (char) 27 + "[31m";
    private final String FOREGROUND_GREEN = (char) 27 + "[32m";
    private final String FOREGROUND_BLUE = (char) 27 + "[34m";

    private final BasicConsole console;

    // Constructor uses dependency injection to get the console object to use for printing.
    public TvShowMovieClientView(BasicConsole console) {
        this.console = console;
    }


    /**
     * Adds a blank line to the display.
     */
    public void displayBlankLine() {
        console.printBlankLine();
    }

    /**
     * Adds a message to the display in normal text.
     * @param message the message to show
     */
    public void displayMessage(String message) {
        console.printMessage(message);
    }

    /**
     * Adds an error message to the display in red text.
     * @param message the message to show
     */
    public void displayErrorMessage(String message) {
        console.printErrorMessage(FOREGROUND_RED + message + FOREGROUND_DEFAULT);
        console.printBlankLine();
    }

    /**
     * Adds an error message to the display in green text.
     * @param message the message to show
     */
    public void displaySuccessMessage(String message) {
        console.printMessage(FOREGROUND_GREEN + message + FOREGROUND_DEFAULT);
        console.printBlankLine();
    }

    /**
     * Displays a welcome message with a green banner.
     */
    public void displayWelcomeMessage() {
        String message = "Welcome to the TV show and Movie Picker (TVMP) Application.";
        console.printBanner(FOREGROUND_GREEN + message + FOREGROUND_DEFAULT);
        console.printBlankLine();
    }


    /**
     * Displays the detail view of a single Tv Show.
     * @param tvShow the Tv Show to display
     */
    public void displayTvShowDetail(TvShow tvShow) {
        displayMessage("TV Show Details:");
        displayMessage(String.format("\tTV Show id: %s", tvShow.getId()));
        displayMessage(String.format("\tName: %s", tvShow.getName()));
        displayMessage(String.format("\tStreaming Service: %s", tvShow.getStreamingService()));
        displayMessage(String.format("\tGenre: %s", tvShow.getGenre1()));
        if (tvShow.getGenre2() != null){
            displayMessage(String.format("\tAlternate / Second Genre: %s", tvShow.getGenre2()));
        }
        displayMessage(String.format("\tDescription: %s", tvShow.getDescription()));
        displayMessage(String.format("\tKeyword 1: %s", tvShow.getKeyword1()));
        displayMessage(String.format("\tKeyword 2: %s", tvShow.getKeyword2()));
        displayMessage(String.format("\tKeyword 3: %s", tvShow.getKeyword3()));
        displayMessage(String.format("\tPerson who suggested it to us: %s", tvShow.getSuggesterName()));
        displayMessage(String.format("\tHave we finished watching the show?: %s", tvShow.isCompleted()? "yes" : "no"));
        displayMessage(String.format("\tIs the show ongoing?: %s", tvShow.isOngoing() ? "yes" : "no"));
        displayMessage(String.format("\tHow many episodes are there?: %s", tvShow.getEpisodeCount()));
        displayMessage(String.format("\tHow many seasons are there?: %s", tvShow.getSeasonCount()));
        displayMessage(String.format("\tEpisode Length?: %s", tvShow.getEpisodeLength()));
        displayMessage(String.format("\tEpisodes Per Season?: %s", tvShow.getEpisodesPerSeason()));
        displayMessage(String.format("\tWhat is the day of Release?: %s", tvShow.getDayOfRelease()));
        console.printBlankLine();
    }

    /**
     * Displays a list of Tv Shows in a table-like format.
     * @param tvShowList the list of Tv Shows to display
     */
    public void displayTvShowList(List<TvShow> tvShowList) {
        if (tvShowList == null) {
            displayErrorMessage("There are no TV shows to show.");
        } else {
            displayMessage("Tv Shows:");
            String heading1 = " Id    Name    Streaming Service     Genre  Alt Genre  Episode Length  Ongoing                                ";
            String heading2 = "====  ======  ===================  =============================================";
            String row1FormatString = "%4d  %6s  %4s  %6s  %6s  %6s  %-40s";
            //String rowFormatString = "%26s  %-40s";
            displayMessage(heading1);
            displayMessage(heading2);
            for (TvShow tvShow : tvShowList) {
                displayMessage(String.format(row1FormatString, tvShow.getId(), tvShow.getName(),
                        tvShow.getStreamingService(), tvShow.getGenre1(), tvShow.getGenre2(), tvShow.getEpisodeLength(), tvShow.isOngoing() ? "Yes" : "No"));
            }
        }
    }

    /**
     * Displays the detail view of a single Movie.
     * @param movie the movie to display
     */
    public void displayMovieDetail(Movie movie) {
        displayMessage("Movie Details:");
        displayMessage(String.format("\tMovie id: %s", movie.getId()));
        displayMessage(String.format("\tName: %s", movie.getName()));
        displayMessage(String.format("\tStreaming Service: %s", movie.getStreamingService()));
        displayMessage(String.format("\tGenre: %s", movie.getGenre1()));
        if (movie.getGenre2() != null){
            displayMessage(String.format("\tAlternate / Second Genre: %s", movie.getGenre2()));
        }
        displayMessage(String.format("\tDescription: %s", movie.getDescription()));
        displayMessage(String.format("\tKeyword 1: %s", movie.getKeyword1()));
        displayMessage(String.format("\tKeyword 2: %s", movie.getKeyword2()));
        displayMessage(String.format("\tKeyword 3: %s", movie.getKeyword3()));
        displayMessage(String.format("\tPerson who suggested it to us: %s", movie.getSuggesterName()));
        displayMessage(String.format("\tHave we watched the movie?: %s", movie.isCompleted()? "yes" : "no"));
        displayMessage(String.format("\tIs the movie free?: %s", movie.isFree() ? "yes" : "no"));
        if(!movie.isFree()) {
            displayMessage(String.format("\tWhats the price of the movie?: %s", movie.getPrice()));
        }
        displayMessage(String.format("\tHow long is the movie?: %s", movie.getRuntimeMinutes()));
        displayMessage(String.format("\tWho directed the movie?: %s", movie.getDirector()));

        console.printBlankLine();
    }

    /**
     * Displays a list of movies in a table-like format.
     *
     * @param movieList the list of movies to display
     */
    public void displayMovieList(List<Movie> movieList) {
        if (movieList == null) {
            displayErrorMessage("There are no movies to show.");
        } else {
            displayMessage("Movies:");
            String heading1 = " Id    Name    Streaming Service        Genre  Alt Genre  Runtime  Director                            ";
            String heading2 = "====  ======  ===================  =============================================";
            String row1FormatString = "%4d  %6s  %4s  %6s  %6s  %6s  %-40s";
            //String rowFormatString = "%26s  %-40s";
            displayMessage(heading1);
            displayMessage(heading2);
            for (Movie movie : movieList) {
                displayMessage(String.format(row1FormatString, movie.getId(), movie.getName(),
                        movie.getStreamingService(), movie.getGenre1(), movie.getGenre2(), movie.getRuntimeMinutes(), movie.getDirector()));
            }
        }
    }

    public void displaySuggesterDetail(Suggester suggester){
        displayMessage("Suggester Details:");
        displayMessage(String.format("\tSuggester Name: %s", suggester.getSuggesterName()));
        console.printBlankLine();
    }

    public void displaySuggesterList(List<Suggester> suggesterList){
        if (suggesterList == null){
            displayErrorMessage("There are no Suggesters to show.");
        } else {
            displayMessage("Suggesters:");
            String heading1 = " Suggester Name ";
            String heading2 = "=================";
            String row1FormatString = "%-40s";

            for (Suggester suggester : suggesterList){
                displayMessage(String.format(row1FormatString,suggester.getSuggesterName()));
            }
        }
    }

    /**
     * Displays a list of menu options, prompting the user to select one
     * @param menuTitle the title of the menu
     * @param options the list of options to choose from
     * @return
     */
    public String selectFromMenu(String menuTitle, String[] options) {
        console.printBanner(FOREGROUND_BLUE + menuTitle + FOREGROUND_DEFAULT);
        String selection = console.getMenuSelection(options);
        console.printBlankLine();
        return selection;
    }

    /**
     * Displays a list of bookmarks, prompting the user to select one.
     * @param tvShows List of TV shows to display
     * @return the selected TV Show, or null if none was selected
     */
    public TvShow selectTvShow(List<TvShow> tvShows) {
        TvShow selected = null;

        if (tvShows == null || tvShows.size() == 0) {
            displayErrorMessage("There are no TV shows to show.");
        } else {
            while (selected == null) {
                displayTvShowList(tvShows);
                Integer tvShowId = console.promptForInteger("Enter TV show id to select [0 to cancel]: ");
                if (tvShowId == null || tvShowId == 0) {
                    // No ID entered, cancel
                    break;
                }
                // ID entered, find bookmark to return todo ask what this does / what this means
                selected = tvShows.stream().filter(t -> t.getId() == tvShowId)
                        .findFirst().orElse(null);
                if (selected == null) {
                    displayErrorMessage("The id entered is not valid, please try again.");
                }
            }
        }
        console.printBlankLine();
        return selected;
    }

    /**
     * Displays a list of movies, prompting the user to select one.
     * @param movies List of movies to display
     * @return the selected movie, or null if none was selected
     */
    public Movie selectMovie(List<Movie> movies) {
        Movie selected = null;

        if (movies == null || movies.size() == 0) {
            displayErrorMessage("There are no movies to show.");
        } else {
            while (selected == null) {
                displayMovieList(movies);
                Integer movieId = console.promptForInteger("Enter movie id to select [0 to cancel]: ");
                if (movieId == null || movieId == 0) {
                    // No ID entered, cancel
                    break;
                }
                // ID was entered, find tag to return
                selected = movies.stream().filter(m -> m.getId() == movieId)
                        .findFirst().orElse(null);
                if (selected == null) {
                    displayErrorMessage("The id entered is not valid, please try again.");
                }
            }
        }
        console.printBlankLine();
        return selected;
    }

    public Suggester selectSuggester(List<Suggester> suggesters){
        Suggester selected = null;

        if (suggesters == null || suggesters.size() == 0){
            displayErrorMessage("There are no suggesters to show.");
        } else {
            while (selected == null){
                displaySuggesterList(suggesters);
                String suggesterName = console.promptForString("Enter Suggester Name to select [0 to cancel]: ");
                if (suggesterName == null || suggesterName.isEmpty()){
                    break;
                }

                selected = suggesters.stream().filter(s -> s.getSuggesterName() == suggesterName).findFirst().orElse(null);
                if (selected == null) {
                    displayErrorMessage("The name entered is not valid, please try again.");
                }
            }
        }
        console.printBlankLine();
        return selected;
    }

    /**
     * Prompts for all Tv Show values that are updatable, showing their current value.
     *   Note: Values update to the entered value using empty/null to clear. They DO NOT default to the current value.
     *
     * @return a new TV Show object with the entered values
     * todo ask what this does / what this means
     */
    public TvShow promptForTvShowUpdate(TvShow existing) {
        TvShow updated = null;
        if (existing != null) {
            console.printMessage("Enter new TV show values");
            updated = new TvShow();
            updated.setName(promptForStringUpdateValue("Name", true, existing.getName()));
            updated.setCompleted(promptForBooleanUpdateValue("Completed?", existing.isCompleted()));
            updated.setOngoing(promptForBooleanUpdateValue("Ongoing?", existing.isOngoing()));
            updated.setEpisodeCount(promptForIntegerUpdateValue("Episode Count?", false, existing.getEpisodeCount()));
            updated.setSeasonCount(promptForIntegerUpdateValue("Season Count?", false, existing.getSeasonCount()));
            updated.setDayOfRelease(promptForStringUpdateValue("Day of Release?", true, existing.getDayOfRelease()));;

        }
        return updated;
    }

    public Movie promptForMovieUpdate(Movie existing) {
        Movie updated = null;
        if (existing != null) {
            console.printMessage("Enter new Movie values");
            updated = new Movie();
            updated.setName(promptForStringUpdateValue("Name", true, existing.getName()));
            updated.setCompleted(promptForBooleanUpdateValue("Watched?", existing.isCompleted()));
            updated.setFree(promptForBooleanUpdateValue("Is it Free?", existing.isFree()));
            if (!existing.isFree()) {
                updated.setPrice(promptForBigDecimalUpdateValue("How much does it cost (0.00)?", false, existing.getPrice()));
            }
            updated.setRuntimeMinutes(promptForIntegerUpdateValue("How long is it?", false, existing.getRuntimeMinutes()));
            updated.setDirector(promptForStringUpdateValue("Who directed the movie?", true, existing.getDirector()));;

        }
        return updated;
    }

    public Suggester promptForSuggesterUpdate(Suggester existing) {
        Suggester updated = null;
        if (existing != null) {
            console.printMessage("Enter new Suggester values");
            updated = new Suggester();
            updated.setSuggesterName(promptForStringUpdateValue("Name", true, existing.getSuggesterName()));

        }
        return updated;
    }

    /**
     * Prompts for the values to create a new TV Show
     * @return a new TV Show object with the values entered
     */
    public TvShow promptForNewTvShowValues() {
        TvShow tvShow = new TvShow();
        tvShow.setName(promptForStringUpdateValue("Name", true, null));
        tvShow.setStreamingService(promptForStringUpdateValue("Streaming Service", true, null));
        tvShow.setGenre1(promptForStringUpdateValue("Genre 1", true, null));
        tvShow.setGenre2(promptForStringUpdateValue("Genre 2", true, null));
        tvShow.setImdbRating(promptForBigDecimalUpdateValue("IMDB Rating", true, null));
        tvShow.setRtRating(promptForIntegerUpdateValue("Rotten Tomatoes Rating", true, null));
        tvShow.setDescription(promptForStringUpdateValue("Description", true, null));
        tvShow.setKeyword1(promptForStringUpdateValue("Keyword 1", true, null));
        tvShow.setKeyword2(promptForStringUpdateValue("Keyword 2", true, null));
        tvShow.setKeyword3(promptForStringUpdateValue("Keyword 3", true, null));
        tvShow.setSuggesterName(promptForStringUpdateValue("Who suggested the show to us?", true, null));
        tvShow.setCompleted(promptForBooleanUpdateValue("Have we completed the show?", false));
        tvShow.setOngoing(promptForBooleanUpdateValue("Is the show ongoing?", false));
        tvShow.setEpisodeCount(promptForIntegerUpdateValue("How many episodes are there?", true, null));
        tvShow.setSeasonCount(promptForIntegerUpdateValue("How many seasons are there?", true, null));
        tvShow.setEpisodeLength(promptForStringUpdateValue("How long are the episodes?", true, null));
        tvShow.setEpisodesPerSeason(promptForStringUpdateValue("How many episodes per season?", true, null));
        tvShow.setDayOfRelease(promptForStringUpdateValue("What day of the week does the show release?", true, null));


        return tvShow;
    }

    public Movie promptForNewMovieValues() {
        Movie movie = new Movie();
        movie.setName(promptForStringUpdateValue("Name", true, null));
        movie.setStreamingService(promptForStringUpdateValue("Streaming Service", true, null));
        movie.setGenre1(promptForStringUpdateValue("Genre 1", true, null));
        movie.setGenre2(promptForStringUpdateValue("Genre 2", true, null));
        movie.setImdbRating(promptForBigDecimalUpdateValue("IMDB Rating", true, null));
        movie.setRtRating(promptForIntegerUpdateValue("Rotten Tomatoes Rating", true, null));
        movie.setDescription(promptForStringUpdateValue("Description", true, null));
        movie.setKeyword1(promptForStringUpdateValue("Keyword 1", true, null));
        movie.setKeyword2(promptForStringUpdateValue("Keyword 2", true, null));
        movie.setKeyword3(promptForStringUpdateValue("Keyword 3", true, null));
        movie.setSuggesterName(promptForStringUpdateValue("Who suggested the movie to us?", true, null));
        movie.setCompleted(promptForBooleanUpdateValue("Have we completed the movie?", false));
        movie.setFree(promptForBooleanUpdateValue("Is the movie free?", false));
        //need to make an ifstatement based on above response unsure how to todo ask Jonathan
        movie.setPrice(promptForBigDecimalUpdateValue("How much does it cost?", true, null));
        movie.setRuntimeMinutes(promptForIntegerUpdateValue("How long is the movie?", true, null));
        movie.setDirector(promptForStringUpdateValue("Who Directed the movie?", true, null));


        return movie;
    }

    public Suggester promptForNewSuggesterValues(){
        Suggester suggester = new Suggester();
        suggester.setSuggesterName(promptForStringUpdateValue("Name" , true, null));
        return suggester;
    }


    //
// Helper functions to support getting user input and basic validation of input values
//
    private String promptForStringUpdateValue(String prompt, boolean required, String currentValue) {
        prompt = promptWithValue(prompt, currentValue);
        while (true) {
            String entry = console.promptForString(prompt);
            if (!entry.isEmpty() || !required) {
                return entry;
            }
            displayErrorMessage("A value is required, please try again.");
        }
    }

    private Integer promptForIntegerUpdateValue(String prompt, boolean required, Integer currentValue) {
        prompt = promptWithValue(prompt, currentValue);
        while (true) {
            Integer entry = console.promptForInteger(prompt);
            if (entry != null || !required) {
                return entry;
            }
            displayErrorMessage("A value is required, please try again.");
        }
    }

    private BigDecimal promptForBigDecimalUpdateValue(String prompt, boolean required, BigDecimal currentValue) {
        prompt = promptWithValue(prompt, currentValue);
        while (true) {
            BigDecimal entry = console.promptForBigDecimal(prompt);
            if (entry != null || !required) {
                return entry;
            }
            displayErrorMessage("A value is required, please try again.");
        }
    }

    private boolean promptForBooleanUpdateValue(String prompt, boolean currentValue) {
        prompt = promptWithValue(prompt, currentValue ? "yes" : "no");
        return console.promptForYesNo(prompt);
    }

    private String promptWithValue(String prompt, Object displayedValue) {
        if (displayedValue != null) {
            return prompt + "[" + displayedValue.toString() + "]: ";
        }
        return prompt + ": ";
    }
}
