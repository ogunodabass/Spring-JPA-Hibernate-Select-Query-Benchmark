package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDto1;
import com.example.demo.dto.UserDto11;
import com.example.demo.dto.UserDto2;
import com.example.demo.entity.User;
import com.example.demo.projections.UserProjection;
import com.example.demo.repo.UserEntityManegerRepository;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional(rollbackFor = Exception.class, readOnly = true)
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserEntityManegerRepository entityManegerRepository;

	public <T> List<T> findBy(Class<T> clazz) {
		return this.userRepository.findBy(clazz);
	}

	public List<UserDto1> findUserDto1() {
		return this.userRepository.findUserDto1();
	}

	//EntityToDTO
	public List<UserDto11> findUserDto11() {
		return this.userRepository.findAllObjectArray().stream().map(UserDto11::objectToDTO)
				.collect(Collectors.toList());
	}

	public List<UserDto1> findAllEM() {
		return this.entityManegerRepository.findAllEM();
	}

	public List<UserProjection> findUserProjection() {
		return this.userRepository.findUserProjection();
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public List<UserDto1> findAllEntityToDto() {
		return this.userRepository.findAll().stream().map(UserDto1::entityToDto).collect(Collectors.toList());
	}

	public List<Object[]> findAllObjectArray() {
		return this.userRepository.findAllObjectArray();
	}

	public List<UserDto2> findAllObjectArray2() {
		return this.userRepository.findAllObjectArray2().stream().map(UserDto2::objectToDTO)
				.collect(Collectors.toList());
	}

	public List<UserDto2> findUserDto2() {
		return this.userRepository.findUserDto2();
	}

	public Streamable<User> findAllStream() {
		return this.userRepository.findAllStream();
	}

	public List<UserDto1> findAllTuple() {
		return this.userRepository.findAllTuple().stream().map(e -> {
			UserDto1 userDto1 = new UserDto1(e.get(0, Long.class), e.get(1, String.class), e.get(2, String.class),
					e.get(3, Long.class), e.get(4, Integer.class), e.get(5, String.class));
			return userDto1;
		}).collect(Collectors.toList());
	}

	public List<Object[]> findAllNativeQuery() {
		return this.userRepository.findAllNativeQuery();
	}

	public List<UserDto1> findAllNativeQuery2() {
		return this.userRepository.findAllNativeQuery2();
	}

	@Transactional(rollbackFor = Exception.class, readOnly = false)
	public List<User> saveAll(Iterable<User> users) {
		return this.userRepository.saveAll(users);
	}
}
