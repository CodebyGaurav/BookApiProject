package com.codebygaurav.WebAppBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.codebygaurav.WebAppBoot.model.Book;
import com.codebygaurav.WebAppBoot.repo.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository ;
	
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Your record is saved";
		 
	}
	
	@PostMapping("/multipleBookSave")
	public String insertBook(@RequestBody List<Book> book) {
		bookRepository.saveAll(book);
		return "All record is saved";
		 
	}
	
	@GetMapping("/getAllBook")
	public List<Book> getBook(){
		return (List<Book>) bookRepository.findAll();
	}
	

	@GetMapping("/getByBookName/{name}")
	public List<Book> getBook(@PathVariable("name") String bookName){
		return (List<Book>) bookRepository.findBybookName(bookName);
	}
	

	@GetMapping("/getByBookId/{bookId}")
	public Optional<Book> getBook(@PathVariable("bookId") Long id){
		return bookRepository.findById(id);
	}
	
	
	
}
