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
			c1.setKategoria("testikategoria");
			categoryRepository.save(c1);

			Show s1 = new Show("sarja1", "Tekija1", "2025-2026", 2000, 9.5, 8.5);
			s1.setCategory(c1);
			showRepository.save(s1);
			//testikäyttäjä
			AppUser user1 = new AppUser("kuisma", "$2a$10$/9k8M2rjtysxMLCLGlfJdeSm3Xh.wdwRoClk5pNw6QezkmduU7maa",
					"ADMIN");
			appUserRepository.save(user1);

			System.out.println("BCrypt test: " +
					passwordEncoder.matches("salasana", user1.getPasswordHash()));
		};
	}

}
