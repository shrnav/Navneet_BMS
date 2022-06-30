package com.navneet.learning.bms.bmsapi.service;

import com.navneet.learning.bms.bmsapi.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
    Movie findByMovieName(String movieName);

    Movie findByMovieId(long movieId);
}
