package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}
	
	@Autowired
	private CandidatRepository candidatRepository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			candidatRepository.save(new Candidat("mariem"));
			candidatRepository.findAll().forEach(System.out::println);
		};
	}

}
