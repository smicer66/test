package com.onyekachiakujua.talkingClock.api.controllers;


import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import com.onyekachiakujua.talkingClock.api.models.requests.TalkingClockRequest;
import com.onyekachiakujua.talkingClock.api.services.TalkingClockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1")
public class TalkingClockController {

    @Autowired
    TalkingClockService talkingClockService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /***
     * Returns the time in a human friendly text format.
     * This method always returns a response irrespective of whether the time is provided as the path variable.
     *
     * @param timeToConvertComponent    the time component to be converted to human hriendly text. Not required. If not provided, the current time will be used
     * @return                          a representation of the time in human friendly text is set as the value of the value key
     */
    @RequestMapping(value = {"/convert-time-to-text", "/convert-time-to-text/{timeToConvertComponent}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TalkingClockResponse convertTimeToHumanFriendlyText(@PathVariable(required = false) String timeToConvertComponent) {
        LocalDateTime timeToConvert = null;
        if(timeToConvertComponent!=null && !timeToConvertComponent.isEmpty())
        {
            LocalDate today = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String todayStr = today.format(dateFormatter);
            todayStr = todayStr.concat(" ").concat(timeToConvertComponent);
            timeToConvert = LocalDateTime.parse(todayStr, dateTimeFormatter);
        }
        else
        {
            timeToConvert = LocalDateTime.now();
        }

        TalkingClockResponse talkingClockResponse = talkingClockService.convertTimeToHumanFriendlyText(timeToConvertComponent);

        return talkingClockResponse;
    }
}
