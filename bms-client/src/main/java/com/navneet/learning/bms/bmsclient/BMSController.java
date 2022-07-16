package com.navneet.learning.bms.bmsclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMSController {

    @Autowired
    private BMSProxy proxy;

    @GetMapping("/bms-client/{theatreName}/{city}/{movieName}/{screeninDate}/{screeningTime}")
    public String getResponse(@PathVariable String theatreName, @PathVariable String city, @PathVariable String movieName, @PathVariable String screeninDate, @PathVariable String screeningTime) {

        return proxy.getBMS(theatreName,city,movieName,screeninDate,screeningTime);
    }
    @GetMapping("/bms-client/{theatreName}/{city}")
    public String getResponseForTheatreByCityAndMovie(@PathVariable String theatreName, @PathVariable String city) {

        return proxy.getBMS(theatreName,city);
    }
}
