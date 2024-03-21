package com.anil.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anil.model.Book;
import com.anil.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping(value="/addbook",consumes = {"application/json"})
	public ResponseEntity<String>addBook(@RequestBody Book book){
		boolean status = bookService.addbook(book);
		if(status) {
			return new ResponseEntity<>("book added successfully",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("book not saved...",HttpStatus.BAD_REQUEST);
		}
	}
}
