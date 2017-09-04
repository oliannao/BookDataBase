package by.htp.database.servise.impl;

import java.util.Date;
import java.util.List;

import by.htp.database.dao.BookDao;
import by.htp.database.dao.impl.BookFileDAO;
import by.htp.database.dao.impl.BookMySqlDAO;
import by.htp.database.domain.entity.Book;
import by.htp.database.domain.vo.Catalog;
import by.htp.database.servise.CatalogService;

public class DefaultCatalogImpl implements CatalogService {
	private BookDao dao;
	{
		// TODO change to factory
		//dao = new BookMySqlDAO();
		dao = new BookFileDAO();
	}

	@Override
	public Catalog getCatalog() {
		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooksWithoutDate();
		catalog.setTitle("New catalog of books");
		catalog.setDataCreation(new Date());
		catalog.setBooks(books);
		return catalog;

	}

	@Override
	public Catalog getCatalog(Date date) {
		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooks(date);
		catalog.setTitle("New catalog of books");
		catalog.setDataCreation(date);
		catalog.setBooks(books);
		return catalog;
	}

	@Override
	public Catalog getCatalogAfterDeletBook(int id) {
		Catalog catalog = new Catalog();
		dao.deletBook(id);
		List<Book> books = dao.fetchBooksWithoutDate();
		catalog.setTitle("New catalog of books");
		catalog.setDataCreation(new Date());
		catalog.setBooks(books);
		return catalog;
	}

	@Override
	public Catalog getCatalogWithNameAndPages(String s, int pages) {
		Catalog catalog = new Catalog();
		List<Book> books = dao.fetchBooksWithNamePages(s, pages);
		catalog.setTitle("New catalog of books");
		catalog.setDataCreation(new Date());
		catalog.setBooks(books);
		return catalog;
	}

}
