package com.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Bookstore.domain.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByAuthorShouldReturnAuthor(){
		List<Book> books = (List<Book>)repository.findAll();
		
		assertThat(books).hasSize(2);
		assertThat(books.get(1).getCategory().getName()).isEqualTo("Business");
	}
	@Test
	public void createNewBook(){
		Book book = new Book("Shoaib","Spring Boot",1234567,2014,5.00,new Category("Programming"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
