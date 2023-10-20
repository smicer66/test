package com.onyekachiakujua.talkingClock.api.services;


import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class TalkingClockServiceTest {

    TalkingClockService talkingClockService;

    @BeforeEach
    public void setUp() {
        this.talkingClockService = new TalkingClockService();
    }

    private Logger logger = LoggerFactory.getLogger(TalkingClockServiceTest.class);


    @Test
    public void convertTimeToHumanFriendlyText(){

        Map<String, String> timeMap = new HashMap<>();
        timeMap.put("01:00", "One o'clock");
        timeMap.put("02:00", "Two o'clock");
        timeMap.put("13:00", "One o'clock");
        timeMap.put("13:05", "Five past one");
        timeMap.put("13:10", "Ten past one");
        timeMap.put("13:25", "Twenty five past one");
        timeMap.put("13:30", "Half past one");
        timeMap.put("13:35", "Twenty five to two");
        timeMap.put("13:55", "Five to two");
        timeMap.put("00:00", "Twelve o'clock");
        timeMap.put("00:10", "Ten past twelve");
        timeMap.put("00:30", "Half past twelve");
        timeMap.put("00:45", "Fifteen to one");
        timeMap.put("01:10", "Ten past one");
        timeMap.put("01:30", "Half past one");
        timeMap.put("01:45", "Fifteen to two");
        timeMap.put("13:10", "Ten past one");
        timeMap.put("13:30", "Half past one");
        timeMap.put("13:45", "Fifteen to two");
        timeMap.put("23:10", "Ten past eleven");
        timeMap.put("23:30", "Half past eleven");
        timeMap.put("23:45", "Fifteen to twelve");

        timeMap.forEach((t,k)->{
            TalkingClockResponse talkingClockResponse = talkingClockService.convertTimeToHumanFriendlyText(t);
            assertEquals(talkingClockResponse.getValue(), k);
        });

    }
}
