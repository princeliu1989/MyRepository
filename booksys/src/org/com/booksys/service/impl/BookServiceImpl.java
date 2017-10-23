package org.com.booksys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.com.booksys.dao.BookDao;
import org.com.booksys.domain.Book;
import org.com.booksys.service.BookService;
import org.springframework.stereotype.Service;
/**
 * @date 2017年6月30日 上午9:41:13
 */
@Service(value="bookService")
public class BookServiceImpl implements BookService
{
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

	@Override
	public int addBook(Book book)
	{
		return (Integer) bookDao.save(book);
	}

	@Override
	public List<Book> getAllBooks()
	{
		return bookDao.findAll(Book.class);
	}

	@Override
	public int deleteBook(int id)
	{
		return bookDao.delete(Book.class, id);
	}

	/* (non-Javadoc)
	 * @see org.com.booksys.service.BookService#getBook()
	 */
	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return bookDao.get(Book.class, id);
	}

	/* (non-Javadoc)
	 * @see org.com.booksys.service.BookService#updateBook()
	 */
	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}
}
