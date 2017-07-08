package net.hudson.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.hudson.domain.mapReduce.CategoryReduced;
import net.hudson.service.BooksService;

@RestController(value="/books")
public class BookController {
	
	@Autowired
	private BooksService bookService;
	
	@GET
	@Produces(value= MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("/category/count")
	public Response cityListMapReduce(){
		Response response;
		List<CategoryReduced> categoryReducedList = bookService.countCategory();
		if(categoryReducedList.isEmpty()){
			response = Response.status(Status.NO_CONTENT).build();
		}else{
			response = Response.status(Status.OK).entity(categoryReducedList).build();
		}
		return response;
	}
}
