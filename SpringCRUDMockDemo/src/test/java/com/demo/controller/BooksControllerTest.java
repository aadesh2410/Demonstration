package com.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.model.Books;
import com.demo.service.BooksServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(value = SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class BooksControllerTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	BooksController booksController;

	@Mock
	BooksServiceImpl booksService;

	@Test
	void test_updateBook() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		Integer id = 6;
		Books books = new Books();
		Books books1 = new Books();
		books.setId(6);
		books.setAuthor("Jay Shetty");
		books.setName("asdnfkjhsa");
		books1.setId(id);
		books1.setName("Revolution 2020");
		books1.setAuthor("Chetan Bhagat");
		
		String booksObjectString = objectMapper.writeValueAsString(books);
		when(booksService.updateBooks(books, id)).thenReturn(books1);
		this.mockMvc.perform(post("/books/update/9").contentType(MediaType.APPLICATION_JSON).content(booksObjectString)).andDo(print()).andExpect(status().isOk());
		
	}
}
