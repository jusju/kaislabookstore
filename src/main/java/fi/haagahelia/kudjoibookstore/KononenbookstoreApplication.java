package fi.haagahelia.kudjoibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import fi.haagahelia.kudjoibookstore.domain.AppUserRepository;
import fi.haagahelia.kudjoibookstore.domain.BookRepository;
import fi.haagahelia.kudjoibookstore.domain.CategoryRepository;
import fi.haagahelia.kudjoibookstore.domain.User;
import fi.haagahelia.kudjoibookstore.domain.Category;

import fi.haagahelia.kudjoibookstore.domain.Book;

@SpringBootApplication
public class KononenbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(KononenbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner addingDemodata(BookRepository bRepository, CategoryRepository cRepository,
			AppUserRepository uRepository) {
		return (args) -> {
			if (cRepository.count() == 0) {
				cRepository.save(new Category("IT"));
				cRepository.save(new Category("Kauhu"));
				cRepository.save(new Category("Talous"));
			}

			if (bRepository.count() == 0) {
				Category it = cRepository.findByName("IT").get(0);
				Category kauhu = cRepository.findByName("Kauhu").get(0);
				Category talous = cRepository.findByName("Talous").get(0);

				bRepository.save(new Book("test", "test", "test", 2012, 20.5, it));
				bRepository.save(new Book("test2", "test2", "test2", 2013, 25.5, kauhu));
				bRepository.save(new Book("test3", "test3", "test3", 2014, 30.5, talous));
			}

			if (uRepository.count() == 0) {
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "ADMIN");

				uRepository.save(user1);
				uRepository.save(user2);
			}
		};
	}
}