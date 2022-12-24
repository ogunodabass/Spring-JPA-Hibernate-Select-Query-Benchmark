package com.example.demo.benchmark;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Objects;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import com.example.demo.Application;
import com.example.demo.service.UserService;

import lombok.AccessLevel;
import lombok.Getter;


@State(Scope.Benchmark)
public class AbstractBenchmark {

	protected UserService userService;
	private ConfigurableApplicationContext context;
	@Getter(value = AccessLevel.PROTECTED)
	private final Runner runner;

	public AbstractBenchmark() {
		ChainedOptionsBuilder optionsBuilder = customChainedOptionsBuilder();
		if (Objects.isNull(optionsBuilder))
			optionsBuilder = globalChainedOptionsBuilder();

		runner = new Runner(optionsBuilder.build());
	}

	@Setup(Level.Trial)
	public void setup() throws RunnerException {

		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "benchmark");
		var springApplication = new SpringApplication(Application.class);
		var context = springApplication.run();
		this.context = context;

		var env = context.getEnvironment();
		assertTrue(Arrays.toString(env.getActiveProfiles()).indexOf("benchmark") > -1);
		assertTrue(env.getProperty("server.port").equals("0"));
		userService = context.getBean(UserService.class);
		assertNotNull(userService);
	}

	@TearDown
	public void close() {
		context.close();
	}

	protected ChainedOptionsBuilder customChainedOptionsBuilder() {
		return null;
	}

	protected final ChainedOptionsBuilder globalChainedOptionsBuilder() {
		ChainedOptionsBuilder options = new OptionsBuilder()
				.include(BechhmarkGroupReturnEntity.class.getSimpleName())
				.include(BechhmarkGroupReturnDynamic.class.getSimpleName())
				.include(BechhmarkGroupDynamicDtoVSProjection.class.getSimpleName())
				.threads(1)
				.warmupForks(0)
				.measurementIterations(50)
				.measurementTime(TimeValue.milliseconds(500))
				.warmupTime(TimeValue.milliseconds(500))
				.shouldDoGC(true)
				.shouldFailOnError(true)
				.jvmArgsAppend("-Xms5120M", "-Xmx10240M")
				.timeout(TimeValue.seconds(10));
		return options;
	}

}
