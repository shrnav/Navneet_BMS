package com.navneet.learning.bms.bmsclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="bms-api")
public interface BMSProxy {
    @RequestMapping(value = "/bms/{theatreName}/{city}/{movieName}/{screeningDate}/{screeningTime}",method = RequestMethod.GET)
    public String getBMS(@PathVariable String theatreName, @PathVariable String city,@PathVariable String movieName, @PathVariable String screeningDate, @PathVariable String screeningTime);
    @RequestMapping(value = "/bms/{theatreName}/{city}",method = RequestMethod.GET)
    public String getBMS(@PathVariable String theatreName, @PathVariable String city);
}
