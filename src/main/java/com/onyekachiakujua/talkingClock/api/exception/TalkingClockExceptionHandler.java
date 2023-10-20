package com.onyekachiakujua.talkingClock.api.exception;

import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockExceptionResponse;
import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@ResponseBody

/**
 * Class for formatting exceptions
 */
public class TalkingClockExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<TalkingClockExceptionResponse> validationException(Exception ex, WebRequest request) {
        logger.error("{}", ex.getMessage());
        TalkingClockExceptionResponse talkingClockExceptionResponse = new TalkingClockExceptionResponse();
        talkingClockExceptionResponse.setMessage("API error encountered.");
        return new ResponseEntity<TalkingClockExceptionResponse>(talkingClockExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
