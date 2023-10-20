package com.onyekachiakujua.talkingClock.api.services;

import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TalkingClockService {

    static String[] numbers = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five", "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine"
    };
    String currentHrInWords = "";
    String currentHrInWordsTo = "";
    int currentHour;
    int currentMins;

    public TalkingClockResponse convertTimeToHumanFriendlyText(String timeInStringFormat)
    {
        LocalDateTime timeToConvert;
        if(timeInStringFormat!=null && !timeInStringFormat.isEmpty())
        {
            LocalDate today = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String todayStr = today.format(dateFormatter);
            todayStr = todayStr.concat(" ").concat(timeInStringFormat);
            timeToConvert = LocalDateTime.parse(todayStr, dateTimeFormatter);
        }
        else
        {
            timeToConvert = LocalDateTime.now();
        }


        currentHour = timeToConvert.getHour();
        currentMins = timeToConvert.getMinute();


        if(currentHour==12)
        {
            currentHrInWords = numbers[currentHour];
            currentHrInWordsTo = numbers[(currentHour%12)+1];
        }
        else if(currentHour==0)
        {
            currentHrInWords = numbers[Math.abs(currentHour+12)];
            currentHrInWordsTo = numbers[currentHour+1];
        }
        else
        {
            currentHrInWords = numbers[Math.abs((currentHour%12))];
            currentHrInWordsTo = numbers[(currentHour%12)+1];
        }



        String currentTimeInWords = "";
        if(currentMins==0)
        {
            currentTimeInWords = currentHrInWords;
            currentTimeInWords = Character.toUpperCase(currentTimeInWords.charAt(0)) + currentTimeInWords.substring(1).concat(" o'clock");
        }
        else if(currentMins==30)
        {
            currentTimeInWords = "Half past ";
            currentTimeInWords = currentTimeInWords.concat(currentHrInWords);
        }
        else if(currentMins>30)
        {
            int currentMinsDiff = 60 - currentMins;
            currentTimeInWords = numbers[currentMinsDiff];
            currentTimeInWords = currentTimeInWords.substring(0, 1).toUpperCase().concat(currentTimeInWords.substring(1)).concat(" to ");
            currentTimeInWords = currentTimeInWords.concat(currentHrInWordsTo);

        }
        else
        {
            currentTimeInWords = numbers[currentMins].substring(0, 1).toUpperCase() + numbers[currentMins].substring(1);
            currentTimeInWords = currentTimeInWords.concat(" past ");
            currentTimeInWords = currentTimeInWords.concat(currentHrInWords);
        }

        TalkingClockResponse talkingClockResponse = new TalkingClockResponse();
        talkingClockResponse.setValue(currentTimeInWords);
        return talkingClockResponse;
    }
}
