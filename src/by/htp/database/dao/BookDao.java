package by.htp.database.dao;

import java.util.Date;
import java.util.List;

import by.htp.database.domain.entity.Book;

public interface BookDao {
	List<Book> fetchBooksWithoutDate();

	List<Book> fetchBooks(Date date);

	Book fetchBook();

	void deletBook(int id);

	List<Book> fetchBooksWithNamePages(String s, int pages);
	
	
}
