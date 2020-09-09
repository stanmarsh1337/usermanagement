package fr.stanislasmarechal.usermanagement;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.stanislasmarechal.usermanagement.core.UserRepository;
import fr.stanislasmarechal.usermanagement.model.User;

@SpringBootApplication
public class UsermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository repository) {
		return args -> {
			Stream.of(new String[] { "test@test.com", "Ferrari", "Jaguar", "Porsche Street" },
					new String[] { "lambor@ghi.ni", "Bugatti", "Gremlin", "Triumph Road" },
					new String[] { "ford@pinto.us", "Yugo GV", "Barney", "Adele Path" }).forEach(tab -> {
						User user = new User(tab[0], tab[1], tab[2], tab[3]);
						repository.save(user);
					});
			repository.findAll().forEach(System.out::println);
		};
	}
}
