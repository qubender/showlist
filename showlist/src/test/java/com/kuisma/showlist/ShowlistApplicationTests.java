package com.kuisma.showlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kuisma.showlist.domain.AppUser;
import com.kuisma.showlist.domain.Category;
import com.kuisma.showlist.domain.Show;
import com.kuisma.showlist.repository.AppUserRepository;
import com.kuisma.showlist.repository.CategoryRepository;
import com.kuisma.showlist.repository.ShowRepository;

@SpringBootTest
class ShowlistApplicationTests {

	@Autowired 
	private AppUserRepository appUserRepository;
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired 
	private ShowRepository showRepository;
	@Autowired 
	CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
		//Toimiiko rooli
		AppUser user = appUserRepository.findByUsername("kuisma");
		assertEquals("ADMIN", user.getRole());

		//Vastaako salasanan hashing alkuperäistä salasanaa
		assertTrue(passwordEncoder.matches("salasana", user.getPasswordHash()));

		//Palautuuko sarja tietokannasta
		Show show = showRepository.findById(1L).orElseThrow();
		assertEquals(1L, show.getId());

		//Toimiiko sarjojen kategoriat
		Category category = categoryRepository.findById(1L).orElseThrow();
		assertEquals(category.getId(), show.getCategory().getId());
	}

}
