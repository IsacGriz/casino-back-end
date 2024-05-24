package com.grzsoftware.cassinobackend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CassinoBackEndApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		String dbUrl = dotenv.get("DATABASE_URL");
		String dbUser = dotenv.get("DATABASE_USER");
		String dbPassword = dotenv.get("DATABASE_PASSWORD");

		if (dbUrl != null || dbUser != null || dbPassword != null) {
			System.setProperty("spring.datasource.url", dbUrl);
			System.setProperty("spring.datasource.username", dbUser);
			System.setProperty("spring.datasource.password", dbPassword);
		}

		SpringApplication.run(CassinoBackEndApplication.class, args);
	}
}
