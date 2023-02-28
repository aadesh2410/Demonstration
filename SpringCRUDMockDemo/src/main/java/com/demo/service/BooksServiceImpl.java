package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Books;
import com.demo.repository.BooksRepository;

//Business logic is implemented inside service layer only

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksRepository booksRepository;

	@Override
	public Books insertBooks(Books books) {
		// actual predefined methods of JPA repository
		// physical connection with the database is made here
		Books b1 = booksRepository.save(books);
		return b1;
	}

	@Override
	public Books updateBooks(Books books, int id) {

		Books b2 = booksRepository.findById(id);
		b2.setAuthor(books.getAuthor());
		b2.setName(books.getName());
		booksRepository.save(b2);
		return b2;

	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> listOBooks = (List<Books>) booksRepository.findAll();
		return listOBooks;
	}

	@Override
	public Books deleteBooks(int id) {
		booksRepository.delete(booksRepository.findById(id));
		return null;
	}

	@Override
	public List<Books> insertMultipleBooks(List<Books> listofBooks) {
		List<Books> listofTemBooks = new ArrayList<>();
		listofTemBooks=(List<Books>) booksRepository.saveAll(listofBooks);
		return listofTemBooks;
		
//		for (Iterator<Books> iterator = listofBooks.iterator(); iterator.hasNext();) {
//			Books books = (Books) iterator.next();
//			Books btemBooks = booksRepository.save(books);
//			listofTemBooks.add(btemBooks);
//		}
//		return listofTemBooks;
	}

	@Override
	public Books getBookById(Integer id) {
		Books books = booksRepository.findById(id);
		return books;
	}
	

}
