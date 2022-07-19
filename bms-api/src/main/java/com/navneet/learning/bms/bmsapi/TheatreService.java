package com.navneet.learning.bms.bmsapi;

import com.navneet.learning.bms.bmsapi.entity.Movie;
import com.navneet.learning.bms.bmsapi.entity.Screening;
import com.navneet.learning.bms.bmsapi.entity.Theatre;
import com.navneet.learning.bms.bmsapi.exception.ElementAlreadyExistException;
import com.navneet.learning.bms.bmsapi.exception.NoSuchElementExistsException;
import com.navneet.learning.bms.bmsapi.service.MovieRepository;
import com.navneet.learning.bms.bmsapi.service.ScreeningRepository;
import com.navneet.learning.bms.bmsapi.service.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController

public class TheatreService {

    @Autowired
    Environment environment;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ScreeningRepository screeningRepository;
    @Autowired
    MovieRepository movieRepository;
    @RequestMapping(value = "/bms/{theatreName}/{city}", method = RequestMethod.GET)
    public String getTheatreByCityAndMovie(@PathVariable String theatreName, @PathVariable String city) {

        //List<Theatre> listOfTheatre = new ArrayList<>();
        Theatre byTheatreNameAndTheatreCity = theatreRepository.findByTheatreNameAndTheatreCity(theatreName, city);

        return "Theatre ID: " + byTheatreNameAndTheatreCity.getTheatreId() + " PORT: " + environment.getProperty("local.server.port");
    }

    @RequestMapping(value = "/bms/{theatreName}/{city}/{movieName}/{screeninDate}/{screeningTime}", method = RequestMethod.GET)
    public List<Screening> getTheatreAndTimingByCityAndMovie(@PathVariable String theatreName, @PathVariable String city, @PathVariable String movieName, @PathVariable String screeninDate, @PathVariable String screeningTime) {

        List<Screening> listOfScreening = new ArrayList<>();
        Theatre byTheatreNameAndTheatreCity = theatreRepository.findByTheatreNameAndTheatreCity(theatreName, city);


        Screening byMovieNameAndTheatreIdAndScreeningDateAndScreeningTime = screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime(movieName, byTheatreNameAndTheatreCity.getTheatreId(), Date.valueOf(screeninDate), Time.valueOf(screeningTime));

        listOfScreening.add(byMovieNameAndTheatreIdAndScreeningDateAndScreeningTime);
        return listOfScreening;
    }

    @RequestMapping(value = "/insert/{theatreCity}/{theatreName}", method = RequestMethod.GET)
    public String insertIntoTheatre(@PathVariable String theatreCity, @PathVariable String theatreName) {
        Theatre theatre = new Theatre(theatreCity, theatreName);
        Theatre byTheatreNameAndTheatreCity = theatreRepository.findByTheatreNameAndTheatreCity(theatreName, theatreCity);

        if(null!=byTheatreNameAndTheatreCity){
            throw new ElementAlreadyExistException("Theatre " +theatreName+" already exist in the city "+theatreCity);
        }
        theatreRepository.save(theatre);

        return "Row inserted successfully with id " + theatre.getTheatreId();
    }


}