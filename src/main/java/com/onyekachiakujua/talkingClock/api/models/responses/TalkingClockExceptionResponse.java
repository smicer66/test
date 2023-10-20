package com.onyekachiakujua.talkingClock.api.models.responses;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalkingClockExceptionResponse {

    /** the converted time component in human hriendly format */
    private String message;
}
