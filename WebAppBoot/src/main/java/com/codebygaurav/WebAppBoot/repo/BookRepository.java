package com.codebygaurav.WebAppBoot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebygaurav.WebAppBoot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findBybookName(String bookName);

	
}
