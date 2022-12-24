package com.example.demo.benchmark.cold;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;

import com.example.demo.benchmark.AbstractBenchmark;

public class TestBenchmarkServiceLayerCold extends AbstractBenchmark {

	public static void main(String[] args) throws RunnerException {

		TestBenchmarkServiceLayerCold benchmark = new TestBenchmarkServiceLayerCold();
		benchmark.getRunner().run();

	}

	@Override
	protected ChainedOptionsBuilder customChainedOptionsBuilder() {
		return globalChainedOptionsBuilder()
				.forks(1)
				.measurementIterations(50)
				.result("jmh-result-cold")
				.output("jmh-result-cold.txt")
				.resultFormat(ResultFormatType.JSON)
				.mode(Mode.SingleShotTime);
	}
}
