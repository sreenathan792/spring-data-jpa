package com.example.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.books.model.Books;
import com.example.books.repository.BooksRepository;

@Service
public class BooksService {
 
	@Autowired
	BooksRepository booksRepo;
	
	@Transactional
	public Books getBook(Long id) {
		Optional<Books> b = booksRepo.findById(id);
		return b.get();
	}
	
	@Transactional
	public List<Books> getBooksByName(String name) {
		List <Books> b = booksRepo.findByBookNameStart(name);
		return b;
	}
	
	@Transactional
	public List<Books> getBooksByPublishedYear(String year) {
		List <Books> b = booksRepo.findByYearPublishedGreaterThan(year);
		return b;
	}

	@Transactional
	public List<Books> getAllBooks() {
		List<Books> list = new ArrayList<>();
		booksRepo.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Transactional
	public void saveBook(Books book) {
		booksRepo.save(book);
	}
	
	@Transactional
	public void deleteBook(Long id) {
		booksRepo.deleteById(id);
	}
}
