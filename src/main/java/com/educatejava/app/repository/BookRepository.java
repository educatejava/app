package com.educatejava.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.educatejava.app.vo.Book;

/**
 * The Interface BookRepository.
 */
@Component
public interface BookRepository extends MongoRepository<Book, String> {
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the book
	 */
	public Book findById(int id);
	
	/**
	 * Find by title.
	 *
	 * @param title the title
	 * @return the list
	 */
	public List<Book> findByTitle(String title);
	
	/**
	 * Find by author.
	 *
	 * @param author the author
	 * @return the list
	 */
	public List<Book> findByAuthor(String author);
	
	/**
	 * Find by publisher.
	 *
	 * @param publisher the publisher
	 * @return the list
	 */
	public List<Book> findByPublisher(String publisher);

}
