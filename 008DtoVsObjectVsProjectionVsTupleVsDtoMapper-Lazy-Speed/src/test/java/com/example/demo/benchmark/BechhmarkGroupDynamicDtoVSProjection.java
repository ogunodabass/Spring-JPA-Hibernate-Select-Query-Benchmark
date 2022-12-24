package com.example.demo.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import com.example.demo.dto.UserDto4;
import com.example.demo.projections.UserProjection2;

@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BechhmarkGroupDynamicDtoVSProjection {

	@Benchmark
	public void findBy_UserProjection2_dynamic(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findBy(UserProjection2.class);
	}

	@Benchmark
	public void findBy_UserDto4_dynamic(AbstractBenchmark abstractBenchmark) {
		abstractBenchmark.userService.findBy(UserDto4.class);
	}

}
