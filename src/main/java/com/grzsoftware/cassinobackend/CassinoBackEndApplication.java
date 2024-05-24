package com.grzsoftware.cassinobackend;

import com.grzsoftware.cassinobackend.entity.Address;
import com.grzsoftware.cassinobackend.entity.User;
import com.grzsoftware.cassinobackend.repository.UserRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class CassinoBackEndApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		String dbUrl = dotenv.get("DATABASE_URL");
		String dbUser = dotenv.get("DATABASE_USER");
		String dbPassword = dotenv.get("DATABASE_PASSWORD");

		if (dbUrl != null || dbUser != null || dbPassword != null) {
			System.setProperty("spring.datasource.url", dbUrl);
			System.setProperty("spring.datasource.username", dbUser);
			System.setProperty("spring.datasource.password", dbPassword);
		}

		SpringApplication.run(CassinoBackEndApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			UserRepository userRepository = ctx.getBean(UserRepository.class);
			User user = new User();
			Address address = new Address();

			address.setStreet("Street");
			address.setCity("City");
			address.setCountry("Country");
			address.setZip("zid");
			address.setNeighbourhood("Neighbourhood");

			user.setUsername("Maicon");
			user.setPassword("123456");
			user.setEmail("maicon@gmail.com");
			user.setCpf("32131232123");
			user.setBirthDate(LocalDate.now());
			user.setBalance(0.0);
			user.setAddress(address);

			System.out.println(userRepository.save(user));
		};
	}
}
