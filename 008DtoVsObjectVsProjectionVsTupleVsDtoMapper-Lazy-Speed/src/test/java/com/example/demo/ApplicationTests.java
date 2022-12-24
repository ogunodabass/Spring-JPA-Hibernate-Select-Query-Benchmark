package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void ex1() {
		assertThat(this.restTemplate.getForEntity("http://localhost:"+port+"/ex1",
				List.class)).isNotNull();
	}
	@Test
	void ex11() {
		assertThat(this.restTemplate.getForEntity("http://localhost:"+port+"/ex11",
				List.class)).isNotNull();
	}


}
