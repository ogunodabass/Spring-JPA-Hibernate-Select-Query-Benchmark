package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

import com.example.demo.entity.Adress;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.repo")

public class Application implements CommandLineRunner {

	@Value("${app.insert.size}")
	private int INSERT_SIZE;

	@Value("${app.insert}")
	private boolean IS_INSERT;

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;

	@Autowired
	private UserService userService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		if (IS_INSERT)
			insert();
	}

	private void insert() throws InterruptedException {

		final var users = new ArrayList<User>(INSERT_SIZE);

		{
			log.info("1start.... ");
			long startTime = System.currentTimeMillis();
			IntStream.range(1, INSERT_SIZE + 1).forEach(index -> {
				String indexStr = index + "";
				var adress = Adress.builder().setHouse("House ".concat(indexStr)).setNo(index).build();
				var user = User.builder().setEmail("Email ".concat(indexStr)).setPassword("Password ".concat(indexStr))
						.setAdress(adress).build();
				users.add(user);
			});
			long endTime = System.currentTimeMillis();
			log.info("1saved " + (endTime - startTime));
		}
		{
			log.info("2start.... ");
			long startTime = System.currentTimeMillis();
			long endTime = System.currentTimeMillis();
			log.info("2saved " + (endTime - startTime));
			Assert.isTrue(userService.saveAll(users).size() == INSERT_SIZE, "data not saved " + INSERT_SIZE);

		}

	}

}
