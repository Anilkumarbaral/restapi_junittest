package com.anil.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public String getWelcomeMsg() {
		return "Welcome to Anil IT!!!";
	}
}
