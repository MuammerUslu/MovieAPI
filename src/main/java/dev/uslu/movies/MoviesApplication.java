package dev.uslu.movies;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Component
	public class MongoConfigLogger {

		private static final Logger logger = LoggerFactory.getLogger(MongoConfigLogger.class);

		@Value("${spring.data.mongodb.uri}")
		private String mongoUri;

		@PostConstruct
		public void logMongoUri() {
			logger.info("MongoDB URI: {}", mongoUri);
		}
	}
}