package by.htp.database.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.database.dao.impl.BookMySqlDAO;
import by.htp.database.domain.entity.Book;

public class BookDaoTest {
	private static BookDao dao;

	@BeforeClass
	public static void initDao() {
		dao = new BookMySqlDAO();
	}

	@Test
	public void testNullList() {

		List<Book> books = dao.fetchBooks(new Date());

		assertNotNull("The returned list is null", books);
	}

	@Test
	public void testEmptyList() {
		List<Book> books = dao.fetchBooks(new Date());
		assertTrue("The returned list contains zero books", books.size() > 0);
	}

	@Test
	public void testEmptyBook() {
		Book book = dao.fetchBook();
		assertNotNull("The returned id is null", book.getId());
		assertNotNull("The returned title is null", book.getTitle());
		assertNotNull("The returned pages is null", book.getPages());
		assertNotNull("The returned date is null", book.getDate());
	}

	@Test
	public void testDeletBook() {
		List<Book> books = dao.fetchBooksWithoutDate();
		dao.deletBook(1);
		List<Book> books1 = dao.fetchBooksWithoutDate();
		assertTrue("The returned size is not 2", books1.size() == 2);
		assertTrue("There is not id=2", books1.get(0).getId() == 2 || books1.get(0).getId() == 3);
		assertTrue("There is not id=2", books1.get(1).getId() == 2 || books1.get(1).getId() == 3);
	}

	@Test
	public void testFetchBooksWithNAmePages() {
		List<Book> books = dao.fetchBooksWithNamePages("Mo", 100);
		for (Book b : books) {
			boolean bo = b.getTitle().contains("Mo");
			boolean p = b.getPages() > 100;
			assertTrue("incorrect book", bo && p);
		}
	}

	@Test
	public void testFetchBooksWithDate() {
		Date date = new Date();
		List<Book> books = dao.fetchBooks(date);
		for (Book b : books) {
			Date datebook = b.getDate();
			assertTrue("incorrect book", datebook.before(date));
		}
	}
}
