package com.vansh.VideoCallApp;

import com.vansh.VideoCallApp.model.User;
import com.vansh.VideoCallApp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService service){
		return args -> {
			service.register(
					User.builder()
					.username("Piya")
					.email("Piya@gmail.com")
					.password("1234")
							.build()
			);
			service.register(
					User.builder()
							.username("Vansh")
							.email("vansh@gmail.com")
							.password("12345")
							.build()
			);
		};
	}
}
