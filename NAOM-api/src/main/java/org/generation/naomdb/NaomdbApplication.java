package org.generation.naomdb;

import org.generation.naomdb.config.JwtFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NaomdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaomdbApplication.class, args);
	}


}
