package com.example.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.Books;
import com.example.books.service.BooksService;

@RestController
@RequestMapping("/library")
public class BooksController {

	@Autowired
	BooksService booksServ;
	
	@GetMapping("/test")
	public String getTest () {
		return "test";
	}
	
	@GetMapping("/books/{id}")
	public Books getBook(@PathVariable(value = "id") Long bookId) {
	    return booksServ.getBook(bookId);
	}
	
	@GetMapping("/books")
	public List<Books> getAllBooks() {
		return booksServ.getAllBooks();
	}
	
	@GetMapping("/books/names/{bookName}")
	public List<Books> getAllBooksByName(@PathVariable(value = "bookName") String bookName) {
		return booksServ.getBooksByName(bookName);
	}
	
	@GetMapping("/books/publish/{year}")
	public List<Books> getAllBooksByPublishedYear(@PathVariable(value = "year") String year) {
		return booksServ.getBooksByPublishedYear(year);
	}
	
	@PostMapping("/books")
	public void saveBooks(@RequestBody Books book) {
		booksServ.saveBook(book);
	}
	
	@DeleteMapping("/delBooks/{id}")
	public void deleteBook(@PathVariable(value = "id") Long bookId) {
		booksServ.deleteBook(bookId);
	}
}
