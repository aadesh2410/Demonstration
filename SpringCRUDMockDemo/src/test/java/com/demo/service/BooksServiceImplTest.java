package com.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.model.Books;
import com.demo.repository.BooksRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebMvc
public class BooksServiceImplTest {
	
	//used for the particular class for which we are writing
	//test cases
	@InjectMocks
	BooksServiceImpl booksServiceImpl;
	
	//used for the autowired classes inside this injectedmock class
	@Mock
	BooksRepository booksRepository;
	
	@Test
	void test_insertBooks() {
		Books books = new Books();
		books.setId(25);
		books.setAuthor("Shakespear");
		books.setName("Romeo and Juliet");
		when(booksRepository.save(books)).thenReturn(books);
		assertEquals(booksServiceImpl.insertBooks(books), books);
	}
	
	@Test
	void test_updateBooks() {
		int id = 25;
		Books book1 = new Books();
		Books book2 = new Books();
		book2.setId(25);
		book1.setId(25);
		book1.setAuthor("Shakespear");
		book1.setName("Romeo and Juliet");
		when(booksRepository.findById(id)).thenReturn(book1);
		book2.setAuthor("Chetan Bhagat");
		book2.setName("One Indian Girl");
		when(booksRepository.save(book2)).thenReturn(book2);
		assertNotEquals(booksServiceImpl.updateBooks(book1, id), book2);
	}
	
	@Test
	void test_getAllBooks() {
		List<Books> listOfBooks = new ArrayList<>();
		Books book1 = new Books();
		Books book2 = new Books();
		book1.setId(25);
		book1.setAuthor("Shakespear");
		book1.setName("Romeo and Juliet");
		book2.setId(20);
		book2.setAuthor("Chetan Bhagat");
		book2.setName("One Indian Girl");
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		when(booksRepository.findAll()).thenReturn(listOfBooks);
		assertEquals(booksServiceImpl.getAllBooks(), listOfBooks);
	}
	 
	@Test
	void test_deleteBooks() {
		int id = 201;
//		Books book1 = new Books();
//		book1.setId(201);
//		book1.setAuthor("Shakespear");
//		book1.setName("Romeo and Juliet");
		when(booksRepository.findById(id)).thenReturn(null);
		
	}
}
