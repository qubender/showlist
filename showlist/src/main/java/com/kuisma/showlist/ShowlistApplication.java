package com.kuisma.showlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kuisma.showlist.domain.AppUser;
import com.kuisma.showlist.domain.Category;
import com.kuisma.showlist.domain.Show;
import com.kuisma.showlist.repository.AppUserRepository;
import com.kuisma.showlist.repository.CategoryRepository;
import com.kuisma.showlist.repository.ShowRepository;

@SpringBootApplication
public class ShowlistApplication {

	private final BCryptPasswordEncoder passwordEncoder;
	private final AppUserRepository appUserRepository;

	ShowlistApplication(AppUserRepository appUserRepository, BCryptPasswordEncoder passwordEncoder) {
		this.appUserRepository = appUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShowlistApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(ShowRepository showRepository, CategoryRepository categoryRepository) {
		return args -> {
			//testi tv-ohjelmat
			Category c1 = new Category();
			c1.setKategoria("Anime");
			categoryRepository.save(c1);

			Category c2 = new Category();
			c2.setKategoria("Drama");
			categoryRepository.save(c2);

			Category c3 = new Category();
			c3.setKategoria("Sci-fi");
			categoryRepository.save(c3);

			Category c4 = new Category();
			c4.setKategoria("Thriller");
			categoryRepository.save(c4);

			Category c5 = new Category();
			c5.setKategoria("Comedy");
			categoryRepository.save(c5);

			Show s1 = new Show("Attack on Titan", "Yasuko Kobayashi", "2025-2026", 2013, 9.1, 9.0);
			s1.setCategory(c1);
			showRepository.save(s1);

			Show s2 = new Show("Shameless", "Paul Abbott", "2015-2020", 2011, 8.5, 8.0);
			s2.setCategory(c2);
			showRepository.save(s2);
			//testikäyttäjä
			AppUser user1 = new AppUser("kuisma", "$2a$10$/9k8M2rjtysxMLCLGlfJdeSm3Xh.wdwRoClk5pNw6QezkmduU7maa",
					"ADMIN");
			appUserRepository.save(user1);

			System.out.println("BCrypt test: " +
					passwordEncoder.matches("salasana", user1.getPasswordHash()));
		};
	}

}
