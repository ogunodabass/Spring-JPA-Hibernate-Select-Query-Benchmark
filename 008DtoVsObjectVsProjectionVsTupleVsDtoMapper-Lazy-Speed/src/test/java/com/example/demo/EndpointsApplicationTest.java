package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EndpointsApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	private final int REQUEST_SIZE = 0;

	@Order(Integer.MIN_VALUE)
	@Test
	public void ex() throws Exception {
		this.mockMvc.perform(get("/temp").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

	@Test
	public void ex1() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex1").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex11() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex11").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex111() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex111").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void ex112() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex1111").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	public void ex2() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex2").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	public void ex22() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex22").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	public void ex222() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex222").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void ex3() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex3").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex4() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex4").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex5() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex5").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex6() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex6").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex7() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex7").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex8() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex8").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void ex9() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/ex9").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());

	}

	@Test
	public void exDynamic1() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/exDynamic1").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void exDynamic11() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/exDynamic11").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void exDynamic111() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/exDynamic111").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void exDynamic2() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/exDynamic2").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void exDynamic3() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/exDynamic3").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}

	@Test
	public void exDynamic4() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			this.mockMvc.perform(get("/exDynamic4").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk());

	}
}