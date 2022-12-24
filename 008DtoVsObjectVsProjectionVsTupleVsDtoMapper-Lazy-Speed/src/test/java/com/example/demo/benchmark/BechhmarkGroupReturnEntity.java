package com.example.demo.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import com.example.demo.dto.UserDto1;
import com.example.demo.projections.UserProjection;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BechhmarkGroupReturnEntity {

	@Benchmark
	public void findBy_UserDto1_dynamic(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findBy(UserDto1.class);
	}

	@Benchmark
	public void findUserDto1_UserDto1_JPQL_Query(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findUserDto1();
	}

	@Benchmark
	public void findUserDto1_UserDto11_EntityToDTO(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findUserDto11();
	}

	@Benchmark
	public void findAllEM_UserDto1_EntityManagerResultTransformer(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllEM();
	}

	@Benchmark
	public void findBy_UserProjection_Dynamic(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findBy(UserProjection.class);
	}

	@Benchmark
	public void findUserProjection_UserProjection_JPQL(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findUserProjection();
	}

	@Benchmark
	public void findAll_User_JPA(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAll();
	}

	@Benchmark
	public void findAllEntityToDto_UserDto1_JPA(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllEntityToDto();
	}

	@Benchmark
	public void findAllObjectArray(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllObjectArray();
	}

	@Benchmark
	public void findAllStream_User(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllStream().toList();
	}

	@Benchmark
	public void findAllTuple_UserDto1(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllTuple();
	}

	@Benchmark
	public void findAllNativeQuery_ObjectArray(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllNativeQuery();
	}

	@Benchmark
	public void findAllNativeQuery2_UserDto1_Dynamic(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllNativeQuery2();
	}
}
