package com.example.demo.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import com.example.demo.dto.UserDto2;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BechhmarkGroupReturnDynamic {

	@Benchmark
	public void findBy_UserDto2_Dynamic(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findBy(UserDto2.class);
	}

	@Benchmark
	public void findAllObjectArray2_UserDto2_objectToUserDto2(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findAllObjectArray2();
	}

	@Benchmark
	public void findUserDto2_UserDto2_JPQL(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findUserDto2();
	}

}
