package com.onyekachiakujua.talkingClock.api.controllers;

import com.onyekachiakujua.talkingClock.api.models.responses.TalkingClockResponse;
import com.onyekachiakujua.talkingClock.api.services.TalkingClockService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TalkingClockControllerTest {
    @MockBean
    TalkingClockService talkingClockService;


    private RestTemplate restTemplate = new RestTemplate();




    @Test
    public void convertTimeToHumanFriendlyTextWithAuthorizationForSpecificTimeTest() throws Exception {

        restTemplate.setInterceptors(
                Collections.singletonList((request, body, execution) -> {
                    request.getHeaders()
                            .add("TALKING-CLOCK-KEY", "b9jhKIh4St+TJp2wBJS+E1CX1dIqgzCs+dIpWdGuDO82mTNsxyWnNrV0OL20O/JP");
                    return execution.execute(request, body);
                }));
        ResponseEntity<TalkingClockResponse> talkingClockResponse = restTemplate.getForEntity("http://localhost:8081/talking-clock/api/v1/convert-time-to-text/13:10", TalkingClockResponse.class);
        assertThat(talkingClockResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        TalkingClockResponse talkingClockResponseCompare = new TalkingClockResponse();
        talkingClockResponseCompare.setValue("Ten past one");

        assertThat(talkingClockResponse.getBody().equals(talkingClockResponseCompare));

    }


    @Test
    public void convertTimeToHumanFriendlyTextWithAuthorizationForCurrentTimeTest() throws Exception {

        restTemplate.setInterceptors(
                Collections.singletonList((request, body, execution) -> {
                    request.getHeaders()
                            .add("TALKING-CLOCK-KEY", "b9jhKIh4St+TJp2wBJS+E1CX1dIqgzCs+dIpWdGuDO82mTNsxyWnNrV0OL20O/JP");
                    return execution.execute(request, body);
                }));
        ResponseEntity<TalkingClockResponse> talkingClockResponse = restTemplate.getForEntity("http://localhost:8081/talking-clock/api/v1/convert-time-to-text", TalkingClockResponse.class);
        assertThat(talkingClockResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        org.assertj.core.api.Assertions.assertThat(!talkingClockResponse.getBody().getValue().isEmpty());

    }

}
