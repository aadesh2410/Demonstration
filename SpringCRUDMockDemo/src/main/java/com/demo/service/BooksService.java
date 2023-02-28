package com.demo.service;

import java.util.List;

import com.demo.model.Books;

public interface BooksService {

	public Books insertBooks(Books books);
	public Books updateBooks(Books books, int id);
	public List<Books> getAllBooks();
	public Books deleteBooks(int id);
	public Books getBookById(Integer id);
	public List<Books> insertMultipleBooks(List<Books> listofBooks);
}
