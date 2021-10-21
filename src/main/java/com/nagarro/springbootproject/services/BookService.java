package com.nagarro.springbootproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.springbootproject.dao.BookRepository;
import com.nagarro.springbootproject.entity.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

//	private static List<Book> books=new ArrayList<Book>();
//
//	
//	static {
////		books.add(new Book(1,007,"Java","Marie","13/05/1999"));
////		books.add(new Book(2,307,"Python","Sam","10/05/2009"));
////		books.add(new Book(3,207,"C++","Bruce","13/02/1991"));
////		books.add(new Book(4,107,"C","Cristopher","03/06/1989"));
//	}

	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	public Book getBook(int id) {
		Book book = null;
		try {
			// book=books.stream().filter(e->e.getId()==id).findFirst().get();
			book = bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	public Book addBook(Book book) {
		Book b = bookRepository.save(book);
		return b;
	}

	public void deleteBook(int id) {
		// books=books.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
	}

	public void updateBook(Book book, int id) {
//		books=books.stream().map(e->{
//			if(e.getId()==id) {
//				e.setCode(book.getCode());
//				e.setName(book.getName());
//				e.setAuthor(book.getAuthor());
//				e.setDate(book.getDate());
//			}
//			return e;
//		}).collect(Collectors.toList());

		book.setId(id);
		bookRepository.save(book);
	}
}
