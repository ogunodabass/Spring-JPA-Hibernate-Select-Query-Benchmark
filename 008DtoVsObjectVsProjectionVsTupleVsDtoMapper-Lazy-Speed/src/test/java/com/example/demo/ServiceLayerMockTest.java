package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.UserDto1;
import com.example.demo.dto.UserDto2;
import com.example.demo.dto.UserDto3;
import com.example.demo.dto.UserDto4;
import com.example.demo.dto.UserDto5;
import com.example.demo.projections.UserProjection;
import com.example.demo.service.UserService;

@SpringBootTest

public class ServiceLayerMockTest {
	@Autowired
	private UserService userService;

	private final int REQUEST_SIZE = 1;

	@Test
	public void ex() throws Exception {
		assertNotNull(5);
	}

	@Test
	public void ex1() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findBy(UserDto1.class));

	}

	@Test
	public void ex11() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findUserDto1());
	}

	@Test
	public void ex111() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findUserDto11());
	}

	@Test
	public void ex112() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllEM());
	}

	@Test
	public void exDynamic1() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findBy(UserDto2.class));
	}

	@Test
	public void exDynamic11() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllObjectArray2());
	}

	@Test
	public void exDynamic111() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findUserDto2());
	}

	@Test
	public void exDynamic2() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findBy(UserDto3.class));
	}

	@Test
	public void exDynamic3() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findBy(UserDto4.class));
	}

	@Test
	public void exDynamic4() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findBy(UserDto5.class));
	}

	public void ex2() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findBy(UserProjection.class));
	}

	public void ex22() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findUserProjection());
	}

	@Test
	public void ex3() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAll());
	}

	@Test
	public void ex4() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(this.userService.findAll().stream().map(UserDto1::entityToDto).collect(Collectors.toList()));
	}

	@Test
	public void ex5() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllObjectArray());
	}

	@Test
	public void ex6() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllStream().toList());
	}

	@Test
	public void ex7() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllTuple());
	}

	@Test
	public void ex8() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllNativeQuery());
	}

	@Test
	public void ex9() throws Exception {
		for (var i = 0; i < REQUEST_SIZE; i++)
			assertNotNull(userService.findAllNativeQuery2());
	}
}