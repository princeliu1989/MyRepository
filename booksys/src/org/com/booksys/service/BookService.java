package org.com.booksys.service;

import java.util.List;

import org.com.booksys.domain.Book;

public interface BookService
{
	// 添加图书
	int addBook(Book book);

	List<Book> getAllBooks();
	
	int deleteBook(int id);
	Book getBook(int id);
	void updateBook(Book book);
}
