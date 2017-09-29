package com.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Bookstore.domain.*;



@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("saving few categories ");
			crepository.save(new Category("Programming"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Arts"));
			crepository.save(new Category("Fiction"));
			
			repository.save(new Book("Ernest Hemingway","A Farewell to Arms",1232323,1929,34.00,crepository.findByName("Programming").get(0)));
			repository.save(new Book("George Orwell","Animal Farm",2212343,1945,34.00,crepository.findByName("Business").get(0)));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
