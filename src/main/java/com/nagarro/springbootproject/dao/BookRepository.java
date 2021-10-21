package com.nagarro.springbootproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.springbootproject.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
