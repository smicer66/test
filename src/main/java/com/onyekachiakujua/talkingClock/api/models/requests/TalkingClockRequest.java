package com.onyekachiakujua.talkingClock.api.models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/***
 * Request representing the time provided by users to be rendered in a human friendly format
 */
public class TalkingClockRequest {

    /** the time component to be converted to human hriendly text. Not required. If not provided, the current time will be used */
    private String time;
}
