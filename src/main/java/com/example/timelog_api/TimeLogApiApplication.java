package com.example.timelog_api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeLogApiApplication {

	public static void main(String[] args) {
		Dotenv d = Dotenv.load();
		String dbUsername = d.get("DB_USERNAME");
		String dbPassword = d.get("DB_PASSWORD");
		String dbUrl = d.get("DB_URL");
		if (dbUsername == null || dbPassword == null || dbUrl == null) {
			System.err.println("One or more required environment variables are missing. Please check your .env file.");
			System.exit(1);
		}
		System.setProperty("DB_USERNAME", dbUsername);
		System.setProperty("DB_PASSWORD", dbPassword);
		System.setProperty("DB_URL", dbUrl);

		SpringApplication.run(TimeLogApiApplication.class, args);
	}

}
