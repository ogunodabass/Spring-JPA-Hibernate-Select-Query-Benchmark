package com.example.demo.visualvmtest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VisualVmTest {

	private static final boolean ENDPOINT_TEST_GC_ENABLED = true;
	private static final int ENDPOINT_TEST_SIZE = 50;
	private static final int ENDPOINT_TEST_SLEEP_FIRST = 1_000;
	private static final int ENDPOINT_TEST_SLEEP_NEXT = 5_000;
	private static final int RESPONSE_DATA_SIZE = 50_000;
	private static final String HOST = "http://localhost:8080/";

	private static final RestTemplate REST_TEMPLATE = new RestTemplate();

	public static void main(String[] args) throws InterruptedException {
		String[] urls = 
			{ "ex1", "ex11", "ex111", "ex1111", "exDynamic1",
					  "exDynamic11", "exDynamic111", "exDynamic2", "exDynamic3", "exDynamic4",
					  "ex2", "ex22", "ex222", "ex3", "ex4", "ex5", "ex6", "ex7", "ex8", "ex9" };
			/*
			{ "ex1", "ex11", "ex111", "ex1111", "exDynamic1", "exDynamic11", "exDynamic111", "exDynamic2",
				"exDynamic3", "exDynamic4", "ex3", "ex4", "ex5", "ex6", "ex7", "ex8", "ex9" };
*/
		/*
		 * projection add.... 
		 * { "ex1", "ex11", "ex111", "ex1111", "exDynamic1",
		 * "exDynamic11", "exDynamic111", "exDynamic2", "exDynamic3", "exDynamic4",
		 * "ex2", "ex22", "ex222", "ex3", "ex4", "ex5", "ex6", "ex7", "ex8", "ex9" };
		 */
		urls = Arrays.stream(urls).map(e -> HOST.concat(e)).toArray(String[]::new);

		TimeUnit.MILLISECONDS.sleep(ENDPOINT_TEST_SLEEP_FIRST);

		response(urls[0]);
		//response(HOST+"ex1");
		
		/*
		 * for (String url : urls) response(url);
		 */
	}

	private static void response(String url) throws InterruptedException {
		List<Long> totalResTime = new ArrayList<Long>(ENDPOINT_TEST_SIZE);

		log.info("		start request: {}", url);
		long n_startTime = System.currentTimeMillis();
		for (var i = 0; i < ENDPOINT_TEST_SIZE; i++) {
			long startTime = System.currentTimeMillis();

			ResponseEntity<Object[]> response = REST_TEMPLATE.getForEntity(url, Object[].class);
			long endTime = System.currentTimeMillis();
			startTime = endTime - startTime;
			totalResTime.add(startTime);
			log.info("		request time: {}", startTime);
			assertTrue(response.getBody().length == RESPONSE_DATA_SIZE);
		}
		long n_endTime = System.currentTimeMillis();
		log.info("{} request time: {}", ENDPOINT_TEST_SIZE, (n_endTime - n_startTime));
		log.info("max: {}\nmin: {}\navg: {}", Collections.max(totalResTime), Collections.min(totalResTime),
				totalResTime.stream().mapToDouble(d -> d).average().orElse(0.0d));
		if (ENDPOINT_TEST_GC_ENABLED)
			System.gc();
		TimeUnit.MILLISECONDS.sleep(ENDPOINT_TEST_SLEEP_NEXT);

	}
}
