package com.demo.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Books;
import com.demo.service.BooksServiceImpl;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BooksServiceImpl booksService;

	//private static final Logger logger = LoggerFactor	// insert operation
	@PostMapping("/insert")
	public String insertBook(@RequestBody Books books) {
		// use service class method
		booksService.insertBooks(books);
		return "insertion successful";
	}

	// update operation
	@PostMapping("/update/{id}")
	public ResponseEntity<Books> updateBook(@RequestBody Books books, @PathVariable("id") Integer id) {
		Books btempBooks = booksService.updateBooks(books, id);
		return ResponseEntity.ok().body(btempBooks);
	}

	// fetch operation
	@GetMapping("/readAll")
	public List<Books> readBooks() {
		List<Books> listofBooks = booksService.getAllBooks();
		// System.out.println(btempBooks);
		return listofBooks;
	}

	// read operation using id
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
		Books books = booksService.getBookById(id);
		return ResponseEntity.ok().body(books);
	}

	// delete operation
	@PostMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Integer id) {
		booksService.deleteBooks(id);
		return "Deletion successful";
	}

	// insert multiple books at a time
	@PostMapping("/insertAll")
	public List<Books> insertAll(@RequestBody List<Books> listofBooks) {
		List<Books> list = booksService.insertMultipleBooks(listofBooks);
		return list;
	}
}
