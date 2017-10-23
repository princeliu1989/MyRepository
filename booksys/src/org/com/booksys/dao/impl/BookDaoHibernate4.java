package org.com.booksys.dao.impl;

import org.com.booksys.dao.BookDao;
import org.com.booksys.domain.Book;
import org.com.common.dao.impl.BaseDaoHibernate4;
import org.springframework.stereotype.Service;

/**
 * @date 2017年6月30日 上午8:51:44
 */
@Service(value="bookDao")
public class BookDaoHibernate4 extends BaseDaoHibernate4<Book>
	implements BookDao
{
}
