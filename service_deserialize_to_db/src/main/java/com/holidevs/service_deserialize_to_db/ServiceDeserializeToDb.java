package com.holidevs.service_deserialize_to_db;

import com.holidevs.service_deserialize_to_db.Entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceDeserializeToDb implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDeserializeToDb.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Marcos Gutierrez", "5356488Q");
	}

}
