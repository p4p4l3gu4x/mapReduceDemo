package net.hudson.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.hudson.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
	
}
