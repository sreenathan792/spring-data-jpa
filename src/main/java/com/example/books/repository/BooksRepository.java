package com.example.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.books.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long> {

	List<Books> findByAuthor(String author);

	@Query("select b from Books b where b.bookName like :st%")
	List<Books> findByBookNameStart(@Param("st") String start);
	
	@Query(value = "select * from books where published_year >= ?", nativeQuery = true)
	List<Books> findByYearPublishedGreaterThan(String year);
}
