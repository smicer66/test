package com.onyekachiakujua.talkingClock.api.controllers;

import com.onyekachiakujua.talkingClock.api.services.TalkingClockService;
import com.onyekachiakujua.talkingClock.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(TalkingClockController.class)
public class TalkingClockControllerWithoutAuthenticationTest {
    @MockBean
    TalkingClockService talkingClockService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockMvc mockMvcWithoutAuthorization;

    @Test
    public void convertTimeToHumanFriendlyTextWithoutAuthorizationTest() throws Exception {
        mockMvcWithoutAuthorization.perform(MockMvcRequestBuilders.get("/api/v1/convert-time-to-text"))
                .andExpect(status().isUnauthorized());
    }


}
