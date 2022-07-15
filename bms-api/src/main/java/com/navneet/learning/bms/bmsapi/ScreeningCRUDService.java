package com.navneet.learning.bms.bmsapi;

import com.navneet.learning.bms.bmsapi.entity.Movie;
import com.navneet.learning.bms.bmsapi.entity.Screen;
import com.navneet.learning.bms.bmsapi.entity.Screening;
import com.navneet.learning.bms.bmsapi.entity.Theatre;
import com.navneet.learning.bms.bmsapi.service.MovieRepository;
import com.navneet.learning.bms.bmsapi.service.ScreenRepository;
import com.navneet.learning.bms.bmsapi.service.ScreeningRepository;
import com.navneet.learning.bms.bmsapi.service.TheatreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ScreeningCRUDService {
    Logger logger = LoggerFactory.getLogger(ScreeningCRUDService.class);
    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "/delete/{screeningDate}", method = RequestMethod.GET)
    public String deleteShowForTheDay(@PathVariable Date screeningDate) {

        List<Screening> byScreeningDate = screeningRepository.findByScreeningDate(screeningDate);
        System.out.println("===" + byScreeningDate.get(0));
        screeningRepository.deleteAll(byScreeningDate);
        logger.info("All shows are deleted for the day:: " + screeningDate);
        return "All shows are deleted for the day:: " + screeningDate;
    }

    @RequestMapping(value = "/create/{theatreName}/{city}/{screeningDate}", method = RequestMethod.GET)
    public String createShowForTheDay(@PathVariable String theatreName, @PathVariable String city, @PathVariable Date screeningDate) {

        List<Screen> listOfScreens = null;
        List<Theatre> listOfTheatre = new ArrayList<>();
        Theatre byTheatreNameAndTheatreCity = theatreRepository.findByTheatreNameAndTheatreCity(theatreName, city);
        if (0L != byTheatreNameAndTheatreCity.getTheatreId()) {
            listOfScreens = screenRepository.findByTheatreId(byTheatreNameAndTheatreCity.getTheatreId());
        }
        for (Screen screen : listOfScreens) {
            Screening screening = new Screening();
            screening.setBookedTickets(0);
            screening.setScreeningTime(java.sql.Time.valueOf("10:00:00"));
            screening.setMovieName("Force");
            screening.setScreeningDate(screeningDate);
            screening.setTheatreId(byTheatreNameAndTheatreCity.getTheatreId());
            screening.setScreenId(screen.getScreenId());
            screeningRepository.save(screening);
        }
        logger.info("show is inserted for the day:: " + screeningDate);
        return "show is inserted for the day:: " + screeningDate;
    }

    @RequestMapping(value = "/update/{screeningDate}/{time}", method = RequestMethod.GET)
    public String updateShowForTheDay(@PathVariable Date screeningDate, @PathVariable Time time) {

        List<Screening> byScreeningDate = screeningRepository.findByScreeningDate(screeningDate);
        for (Screening screening : byScreeningDate) {
            screening.setScreeningTime(time);
            screeningRepository.save(screening);
        }


        logger.info("show is inserted for the day:: " + screeningDate);
        return "show has been :: " + screeningDate;
    }

    @RequestMapping(value = "/getAllScreening", method = RequestMethod.GET)
    public Iterable<Screening> getAllScreening() {

        Iterable<Screening> all = screeningRepository.findAll();
        all.forEach(System.out::println);
        return all;

    }

    @RequestMapping(value = "/getAllMovies", method = RequestMethod.GET)
    public Iterable<Movie> getAllMovies() {

        return movieRepository.findAll();
    }
    @RequestMapping(value = "/getAllScreen", method = RequestMethod.GET)
    public Iterable<Screen> getAllScreen() {

        return screenRepository.findAll();
    }

}
