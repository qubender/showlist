package com.kuisma.showlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kuisma.showlist.domain.Show;
import com.kuisma.showlist.repository.ShowRepository;

@SpringBootApplication
public class ShowlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowlistApplication.class, args);
	}

	@Bean 
	CommandLineRunner demo(ShowRepository showRepository) {
		return args -> {
			Show s1 = new Show("sarja1", "Tekija1", "2025-2026", 2000, 9.5, 8.5);
			showRepository.save(s1);
		};
	}

}
