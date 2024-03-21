package com.anil.service;

import org.springframework.stereotype.Service;

import com.anil.model.Book;

@Service
public class BookService {

	public boolean addbook(Book book) {
		if(book!=null)
		return true;
		else {
			return false;
		}
	}
}
