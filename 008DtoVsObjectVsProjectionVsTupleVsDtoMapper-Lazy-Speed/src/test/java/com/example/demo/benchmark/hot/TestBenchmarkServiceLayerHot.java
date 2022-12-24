package com.example.demo.benchmark.hot;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.WarmupMode;

import com.example.demo.benchmark.AbstractBenchmark;


public class TestBenchmarkServiceLayerHot extends AbstractBenchmark {

	public static void main(String[] args) throws RunnerException {

		TestBenchmarkServiceLayerHot benchmark = new TestBenchmarkServiceLayerHot();
		benchmark.getRunner().run();
	}

	@Override
	protected ChainedOptionsBuilder customChainedOptionsBuilder() {
		return globalChainedOptionsBuilder()
				.threads(1)
				.warmupIterations(5)
				.measurementIterations(20)
				.warmupMode(WarmupMode.BULK_INDI)
				.forks(1)
				.result("jmh-result-hot.json")
				.output("jmh-result-hot.txt")
				.resultFormat(ResultFormatType.JSON)
				.mode(Mode.AverageTime);
	}
}
