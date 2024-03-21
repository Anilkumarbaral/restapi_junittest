package com.anil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.anil.model.Book;
import com.anil.rest.BookController;
import com.anil.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value=BookController.class)
public class BookControllerTest {

	@MockBean
	private BookService bookService;
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void addbook1() throws Exception {
		when(bookService.addbook(ArgumentMatchers.any())).thenReturn(true);
		
		 Book b=new Book();
		 b.setBookId(11);
		 b.setBookName("java");
		 b.setBookPrice(3000.0);
		 
		 ObjectMapper objm=new ObjectMapper();
		 String writeValueAsString = objm.writeValueAsString(b);
		//create the request
		 MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addbook")
				                                        .contentType(MediaType.APPLICATION_JSON)
				                                        .content(writeValueAsString);
	   //send request		                                        
		 ResultActions perform = mockMvc.perform(requestBuilder);
		 MvcResult andReturn = perform.andReturn();
		 MockHttpServletResponse response = andReturn.getResponse();
		 int status = response.getStatus();
		 
		 assertEquals(201, status);
	}
	@Test
	public void addbook2() throws Exception {
		when(bookService.addbook(ArgumentMatchers.any())).thenReturn(false);
		
		Book b=new Book();
		b.setBookId(11);
		b.setBookName("java");
		b.setBookPrice(3000.0);
		
		ObjectMapper objm=new ObjectMapper();
		String writeValueAsString = objm.writeValueAsString(b);
		//create the request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addbook")
				.contentType(MediaType.APPLICATION_JSON)
				.content(writeValueAsString);
		//send request		                                        
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		
		assertEquals(400, status);
	}
}
