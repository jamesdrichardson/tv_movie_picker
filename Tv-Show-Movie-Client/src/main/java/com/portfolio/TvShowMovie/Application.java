package com.portfolio.TvShowMovie;

import com.portfolio.util.BasicConsole;
import com.portfolio.util.SystemInOutConsole;

public class Application {

    private static final String API_BASE_URL = "https://localhost:9001";
    public static void main(String[] args) {

        BasicConsole systemInOutConsole = new SystemInOutConsole();

       TvShowMovieClientController controller = new TvShowMovieClientController(systemInOutConsole , API_BASE_URL);
       controller.run();
    }
}