package com.navneet.learning.bms.bmsapi.service;

import com.navneet.learning.bms.bmsapi.entity.Screen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScreenRepository extends CrudRepository<Screen, Long> {
    public Screen findByScreenId(long screenId);

    public List<Screen> findByTheatreId(long theatreId);
}
