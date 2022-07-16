package com.navneet.learning.bms.bmsapi.runner;

import com.navneet.learning.bms.bmsapi.entity.Movie;
import com.navneet.learning.bms.bmsapi.entity.Screen;
import com.navneet.learning.bms.bmsapi.entity.Screening;
import com.navneet.learning.bms.bmsapi.entity.Theatre;
import com.navneet.learning.bms.bmsapi.service.MovieRepository;
import com.navneet.learning.bms.bmsapi.service.ScreenRepository;
import com.navneet.learning.bms.bmsapi.service.ScreeningRepository;
import com.navneet.learning.bms.bmsapi.service.TheatreRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//import org.springframework.core.task.TaskExecutor;
@Slf4j
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    public DataLoader(MovieRepository movieRepository, ScreeningRepository screeningRepository,
                      ScreenRepository screenRepository) {
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
        this.screenRepository = screenRepository;
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public ScreeningRepository getScreeningRepository() {
        return screeningRepository;
    }

    public ScreenRepository getScreenRepository() {
        return screenRepository;
    }

    private void populateMovieTable() {
        try (BufferedReader brMovies = new BufferedReader(new InputStreamReader(new ClassPathResource("movies.medium.csv").getInputStream()));
             BufferedReader brLinks = new BufferedReader(new InputStreamReader(new ClassPathResource("links.csv").getInputStream()))) {
            String movieLine;
            String linkLine;
            brMovies.readLine();    // Skip header line
            brLinks.readLine();     // Skip header line
            while ((movieLine = brMovies.readLine()) != null) {
                linkLine = brLinks.readLine();

            log.info("new ProcessMovie(movieLine, linkLine)===" + new ProcessMovie(movieLine, linkLine));
                new ProcessMovie(movieLine, linkLine).run();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateScreeningsTable() throws CloneNotSupportedException {
           for (int i = 2; i <= 6; i++) {
            List<Screen> screens = screenRepository.findByTheatreId(i);

            for (int j = 1; j < screens.size(); j++) {
                Screening screening1 = new Screening();
                Screening screening2 = new Screening();

                screening1.setTheatreId(i);
                screening1.setScreenId(j + 1);
                screening2.setTheatreId(i);
                screening2.setScreenId(j + 1);

                // Randomly select 2 movies from the movies db, 1 each for each screen
                long totalMovies = movieRepository.count();
                Random random = new Random();

                long movieId1 = random.nextInt((int) totalMovies) + 1;
                Movie movie1 = null;
                while ((movie1 = movieRepository.findByMovieId(movieId1)) == null)
                    movieId1 = random.nextInt((int) totalMovies) + 1;

                long movieId2 = random.nextInt((int) totalMovies) + 1;
                Movie movie2 = null;
                while ((movie2 = movieRepository.findByMovieId(movieId2)) == null)
                    movieId2 = random.nextInt((int) totalMovies) + 1;

                screening1.setMovieName(movie1.getMovieName());
                screening2.setMovieName(movie2.getMovieName());

                // Get a random date between current date and 3 days from current date
                Date date1 = new Date((new java.util.Date()).getTime());
                Date date2 = new Date(date1.getTime() + 3 * 24 * 60 * 60 * 1000);
                Date randomDate1 = new Date(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));
                Date randomDate2 = new Date(ThreadLocalRandom.current().nextLong(date1.getTime(), date2.getTime()));

                screening1.setScreeningDate(randomDate1);
                screening2.setScreeningDate(randomDate2);

                screening1.setBookedTickets(0);
                screening2.setBookedTickets(0);

                // 2 screenings per screen
                screening1.setScreeningTime(Time.valueOf("10:00:00"));

                screeningRepository.save(screening1);

                Screening screening1Clone = (Screening) screening1.clone();
                screening1.setScreeningTime(Time.valueOf("18:00:00"));
                screeningRepository.save(screening1Clone);

                if (randomDate1.getDate() != randomDate2.getDate()) {
                    screening2.setScreeningTime(Time.valueOf("10:00:00"));
                    screeningRepository.save(screening2);

                    Screening screening2Clone = (Screening) screening2.clone();
                    screening2.setScreeningTime(Time.valueOf("18:00:00"));
                    screeningRepository.save(screening2Clone);
                }
            }
        }
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        populateTheaterTable();
        populateScreenTable();
        populateMovieTable();
        populateScreeningsTable();
    }

    private void populateScreenTable() {
        Screen screen = new Screen(2, 100);
        Screen screen1 = new Screen(3, 200);
        Screen screen2 = new Screen(4, 400);
        Screen screen3 = new Screen(5, 100);
        Screen screen4 = new Screen(6, 24);
        Screen screen5 = new Screen(2, 800);
        Screen screen6 = new Screen(4, 150);
        Screen screen7 = new Screen(5, 90);

        screenRepository.save(screen);
        screenRepository.save(screen1);
        screenRepository.save(screen2);
        screenRepository.save(screen3);
        screenRepository.save(screen4);
        screenRepository.save(screen5);
        screenRepository.save(screen6);
        screenRepository.save(screen7);
    }

    private void populateTheaterTable() {
        Theatre theatre = new Theatre("PVR", "Noida");
        Theatre theatre1 = new Theatre("INOX", "Noida");
        Theatre theatre2 = new Theatre("Suncity", "Noida");
        Theatre theatre3 = new Theatre("DLF", "Noida");
        Theatre theatre4 = new Theatre("Logix", "Noida");
        theatreRepository.save(theatre);
        theatreRepository.save(theatre1);
        theatreRepository.save(theatre2);
        theatreRepository.save(theatre3);
        theatreRepository.save(theatre4);

    }

    private class ProcessMovie implements Runnable {
        private String movieLine;
        private String linkLine;

        ProcessMovie(String movieLine, String linkLine) {
            this.movieLine = movieLine;
            this.linkLine = linkLine;
        }

        @Override
        public void run() {
            log.info(Thread.currentThread().getId() + ":" + linkLine);
            String[] movieInfo = movieLine.split(",");

            String movieName = "";

            for (int i = 1; i < movieInfo.length - 1; i++) {
                if (i == movieInfo.length - 2)
                    movieName += movieInfo[i];
                else
                    movieName += movieInfo[i] + ",";
            }

            Movie movie = new Movie();
            movie.setMovieId(Long.parseLong(movieInfo[0]));
            movie.setMovieName(movieName.substring(0, movieName.indexOf('(')).trim());
            movie.setMovieTags(movieInfo[2]);
            movieRepository.save(movie);
        }
    }
}
