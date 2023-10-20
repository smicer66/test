package com.onyekachiakujua.talkingClock;

import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import com.onyekachiakujua.talkingClock.api.services.TalkingClockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Scanner;

public class ObjectiveTwo {

    private static Logger logger = LoggerFactory.getLogger(ObjectiveOne.class);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();


        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String todayStr = today.format(dateFormatter);
        todayStr = todayStr.concat(" ").concat(input);
        LocalDateTime now = LocalDateTime.parse(todayStr, dateTimeFormatter);
        TalkingClockService talkingClockService = new TalkingClockService();
        TalkingClockResponse talkingClockResponse = talkingClockService.convertTimeToHumanFriendlyText(input);
        logger.info("Time inputted is {} - {}", input, talkingClockResponse.getValue());


    }
}
