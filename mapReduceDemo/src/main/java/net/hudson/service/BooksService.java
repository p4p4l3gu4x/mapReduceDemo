package net.hudson.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Service;

import net.hudson.domain.Author;
import net.hudson.domain.Book;
import net.hudson.domain.Publisher;
import net.hudson.domain.mapReduce.CategoryReduced;
import net.hudson.repository.BookRepository;

@Service
public class BooksService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MongoOperations mongoOperations;

	public List<CategoryReduced> countCategory() {
		String mapFunctionCity = "classpath:js/map/mapByCategory.js";
		String reduceFunctionCity = "classpath:js/reduce/reduceCount.js";

		MapReduceResults<CategoryReduced> mapReduce = mongoOperations.mapReduce("books", mapFunctionCity,
				reduceFunctionCity, CategoryReduced.class);
		List<CategoryReduced> categoryReducedList = new ArrayList<CategoryReduced>();
		for (CategoryReduced categoryReduced : mapReduce) {
			categoryReducedList.add(categoryReduced);
		}
		return categoryReducedList;
	}
	
	@PostConstruct
	private void initializeDb() {
		if(bookRepository.count() > 0){
			bookRepository.deleteAll();

			BigDecimal hundred = new BigDecimal(100); //to avoid problem with locale
			List<Book> books = new ArrayList<Book>();
			
			Book book = new Book();
			books.add(book);
			
			book.setTitle("MongoDB: The Definitive Guide");
			book.setPublished(new Date(2013, 05, 23));
			
			book.setAuthors(new ArrayList<Author>(1));
			book.getAuthors().add(new Author("Kristina", "Chodorow"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
			
			book.setPublisher(new Publisher("O'Reilly"));
			book.setPrice(new BigDecimal(3299).divide(hundred)); //to avoid problem with locale
	
			
			book = new Book();
			books.add(book);
			
			book.setTitle("MongoDB Applied Design Patterns");
			book.setPublished(new Date(2013, 03, 19));
			
			book.setAuthors(new ArrayList<Author>(1));
			book.getAuthors().add(new Author("Rick", "Copeland"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Patterns");
			book.getCategories().add("Programming");
			
			book.setPublisher(new Publisher("O'Reilly"));
			book.setPrice(new BigDecimal(3299).divide(hundred)); //to avoid problem with locale
			
			
			book = new Book();
			books.add(book);
			
			book.setTitle("MongoDB in Action");
			book.setPublished(new Date(2011, 12, 16));
			
			book.setAuthors(new ArrayList<Author>(1));
			book.getAuthors().add(new Author("Kyle", "Banker"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
			
			book.setPublisher(new Publisher("Manning"));
			book.setPrice(new BigDecimal(3083).divide(hundred)); //to avoid problem with locale
			
			
			book = new Book();
			books.add(book);
			
			book.setTitle("NoSQL Distilled: A Brief Guide to the Emerging World of Polyglot Persistence");
			book.setPublished(new Date(2012, 8, 18));
			
			book.setAuthors(new ArrayList<Author>(2));
			book.getAuthors().add(new Author("Pramod J.", "Sadalage"));
			book.getAuthors().add(new Author("Martin", "Fowler"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			
			book.setPublisher(new Publisher("Addison Wesley"));
			book.setPrice(new BigDecimal(2636).divide(hundred)); //to avoid problem with locale
	
			
			book = new Book();
			books.add(book);
			
			book.setTitle("Scaling MongoDB");
			book.setPublished(new Date(2011, 3, 07));
			
			book.setAuthors(new ArrayList<Author>(1));
			book.getAuthors().add(new Author("Kristina", "Chodorow"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			
			book.setPublisher(new Publisher("O'Reilly"));
			book.setPrice(new BigDecimal(2530).divide(hundred)); //to avoid problem with locale
	
			
			book = new Book();
			books.add(book);
			
			book.setTitle("50 Tips and Tricks for MongoDB Developers");
			book.setPublished(new Date(2011, 5, 06));
			
			book.setAuthors(new ArrayList<Author>(1));
			book.getAuthors().add(new Author("Kristina", "Chodorow"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
			
			book.setPublisher(new Publisher("O'Reilly"));
			book.setPrice(new BigDecimal(2508).divide(hundred)); //to avoid problem with locale
			
			
			book = new Book();
			books.add(book);
			
			book.setTitle("MongoDB in Action, 2nd Edition");
			book.setPublished(new Date(2014, 12, 01));
			
			book.setAuthors(new ArrayList<Author>(3));
			book.getAuthors().add(new Author("Kyle", "Banker"));
			book.getAuthors().add(new Author("Peter", "Bakkum"));
			book.getAuthors().add(new Author("Tim", "Hawkins"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
			
			book.setPublisher(new Publisher("Manning"));
			book.setPrice(new BigDecimal(2666).divide(hundred)); //to avoid problem with locale
			
			
			book = new Book();
			books.add(book);
			
			book.setTitle("Node.js, MongoDB, and AngularJS Web Development");
			book.setPublished(new Date(2014, 4, 04));
			
			book.setAuthors(new ArrayList<Author>(3));
			book.getAuthors().add(new Author("Brad", "Dayley"));
			book.getAuthors().add(new Author("Peter", "Bakkum"));
			book.getAuthors().add(new Author("Tim", "Hawkins"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
			book.getCategories().add("Web");
					
			book.setPublisher(new Publisher("Addison Wesley"));
			book.setPrice(new BigDecimal(3435).divide(hundred)); //to avoid problem with locale
			
			
			book = new Book();
			books.add(book);
			
			book.setTitle("MongoDB and Python: Patterns and processes for the popular document-oriented database");
			book.setPublished(new Date(2011, 9, 30));
			
			book.setAuthors(new ArrayList<Author>(3));
			book.getAuthors().add(new Author("Niall", "O'Higgins"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
					
			book.setPublisher(new Publisher("O'Reilly"));
			book.setPrice(new BigDecimal(3435).divide(hundred)); //to avoid problem with locale
			
			
			book = new Book();
			books.add(book);
			
			book.setTitle("Node.js in Action");
			book.setPublished(new Date(2013, 11, 28));
			
			book.setAuthors(new ArrayList<Author>(3));
			book.getAuthors().add(new Author("Mike", "Cantelon"));
			
			book.setCategories(new ArrayList<String>(3));
			book.getCategories().add("Databases");
			book.getCategories().add("NoSQL");
			book.getCategories().add("Programming");
			book.getCategories().add("Web");
					
			book.setPublisher(new Publisher("Manning"));
			book.setPrice(new BigDecimal(2609).divide(hundred)); //to avoid problem with locale
	
			bookRepository.saveAll(books);
		}
	}
}
