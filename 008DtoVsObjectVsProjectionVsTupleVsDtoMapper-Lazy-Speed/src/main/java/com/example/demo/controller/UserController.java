package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto1;
import com.example.demo.dto.UserDto11;
import com.example.demo.dto.UserDto2;
import com.example.demo.dto.UserDto3;
import com.example.demo.dto.UserDto4;
import com.example.demo.dto.UserDto5;
import com.example.demo.entity.User;
import com.example.demo.projections.UserProjection;
import com.example.demo.projections.UserProjection2;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PersistenceContext
	private EntityManager em;
	
	@GetMapping(value = "temp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> temp() {
		Session session = em.unwrap(Session.class);

		Statistics statistics = session.getSessionFactory().getStatistics();
		statistics.logSummary();
		return ResponseEntity.ok(null);
	}

	@GetMapping(value = "ex1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto1>> exDto() {
		return ResponseEntity.ok(userService.findBy(UserDto1.class));
	}

	@GetMapping(value = "ex11", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto1>> exDto2() {
		return ResponseEntity.ok(userService.findUserDto1());
	}

	@GetMapping(value = "ex111", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto11>> exDto4() {
		return ResponseEntity.ok(userService.findUserDto11());
	}
	
	@GetMapping(value = "ex1111", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto1>> findAllEM() {
		return ResponseEntity.ok(userService.findAllEM());
	}

	@GetMapping(value = "exDynamic1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto2>> exDynamic1() {
		return ResponseEntity.ok(userService.findBy(UserDto2.class));
	}

	@GetMapping(value = "exDynamic11", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto2>> exDynamic11() {
		return ResponseEntity.ok(userService.findAllObjectArray2());
	}

	@GetMapping(value = "exDynamic111", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto2>> exDynamic111() {
		return ResponseEntity.ok(userService.findUserDto2());
	}


	@GetMapping(value = "exDynamic2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto3>> exDynamic2() {
		return ResponseEntity.ok(userService.findBy(UserDto3.class));
	}

	@GetMapping(value = "exDynamic3", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto4>> exDynamic3() {
		return ResponseEntity.ok(userService.findBy(UserDto4.class));
	}

	@GetMapping(value = "exDynamic4", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto5>> exDynamic4() {
		return ResponseEntity.ok(userService.findBy(UserDto5.class));
	}

	@GetMapping(value = "ex2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserProjection>> exProjection() {
		return ResponseEntity.ok(userService.findBy(UserProjection.class));
	}

	@GetMapping(value = "ex22", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserProjection>> exProjection2() {
		return ResponseEntity.ok(userService.findUserProjection());
	}
	
	@GetMapping(value = "ex222", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserProjection2>> exProjection3() {
		return ResponseEntity.ok(userService.findBy(UserProjection2.class));
	}

	@GetMapping(value = "ex3", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> exEntity() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping(value = "ex4", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto1>> exEntityToDto() {
		return ResponseEntity
				.ok(this.userService.findAllEntityToDto());
	}

	@GetMapping(value = "ex5", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object[]>> exArray() {
		return ResponseEntity.ok(userService.findAllObjectArray());
	}

	@GetMapping(value = "ex6", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> exStream() {
		return ResponseEntity.ok(userService.findAllStream().toList());
	}

	@GetMapping(value = "ex7", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto1>> exTuple() {
		return ResponseEntity.ok(userService.findAllTuple());
	}

	@GetMapping(value = "ex8", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object[]>> exNativeQuery() {
		return ResponseEntity.ok(userService.findAllNativeQuery());
	}

	@GetMapping(value = "ex9", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto1>> exNativeQueryToDto() {
		return ResponseEntity.ok(userService.findAllNativeQuery2());
	}
}
