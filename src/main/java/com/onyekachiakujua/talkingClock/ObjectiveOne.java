package com.onyekachiakujua.talkingClock;

import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import com.onyekachiakujua.talkingClock.api.services.TalkingClockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObjectiveOne {

    private static Logger logger = LoggerFactory.getLogger(ObjectiveOne.class);


    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        TalkingClockService talkingClockService = new TalkingClockService();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String nowStr = now.format(dateTimeFormatter);
        TalkingClockResponse talkingClockResponse = talkingClockService.convertTimeToHumanFriendlyText(nowStr.split(" ")[1]);
        logger.info("Current time is {} - {}", nowStr.split(" ")[1], talkingClockResponse.getValue());
    }
}
