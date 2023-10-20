package com.onyekachiakujua.talkingClock;

import com.onyekachiakujua.talkingClock.api.services.TalkingClockService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TalkingClockApplicationTests {

	@Autowired
	TalkingClockService talkingClockService;

	@DisplayName("Student service find by Id test")
	@Test
	void contextLoads() {
		assertThat(talkingClockService).isNotNull();
	}

}
