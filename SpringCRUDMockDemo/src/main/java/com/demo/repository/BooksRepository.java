package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Serializable> {
	
	public Books findById(Integer id);
}
