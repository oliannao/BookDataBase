package by.htp.database.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.database.domain.entity.Book;
import by.htp.database.domain.vo.Catalog;
import by.htp.database.servise.CatalogService;
import by.htp.database.servise.impl.DefaultCatalogImpl;

public class CatalogServiceTest {
	private static CatalogService service;

	@BeforeClass
	public static void initCatalogServiceTest() {
		service = new DefaultCatalogImpl();
	}

	@Test
	public void testCatalogNotNull() {
		// fail("Not yet implemented");
		Catalog catalog = service.getCatalog();
		assertNotNull("the catalog was not created", catalog);
	}

	@Test
	public void testCatalogNotEmpty() {

		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog title was not filled", catalog.getTitle());
		assertNotNull("The date of creation was not set", catalog.getDataCreation());
		assertNotNull("The book list was not attached to catalog item", catalog.getBooks());
	}

	@Test
	public void testCatalogEmptyBooks() {

		Catalog catalog = service.getCatalog();
		assertNotNull("The book list was not attached to catalog item", catalog.getBooks());
		assertTrue("The books list is empty", catalog.getBooks().size() > 0);
	}

	@Test
	public void testGetCatalogWithDate() {
		Date date = new Date();
		Catalog catalog = service.getCatalog(date);
		assertNotNull("The catalog title was not filled", catalog.getTitle());
		assertNotNull("The date of creation was not set", catalog.getDataCreation());
		assertNotNull("The book list was not attached to catalog item", catalog.getBooks());
		assertTrue("The books list is empty", catalog.getBooks().size() > 0);
		for (Book b : catalog.getBooks()) {
			Date dateBook = b.getDate();
			assertTrue("Incorrect book", dateBook.before(date));
		}

	}

	@Test
	public void testGetCatalogAfterDeletBook() {
		Catalog catalog = service.getCatalogAfterDeletBook(1);
		assertNotNull("The catalog title was not filled", catalog.getTitle());
		assertNotNull("The date of creation was not set", catalog.getDataCreation());
		assertNotNull("The book list was not attached to catalog item", catalog.getBooks());
		assertTrue("The books list is empty", catalog.getBooks().size() == 2);
	}

	@Test
	public void testGetCatalogWithNameAndPages() {
		Catalog catalog = service.getCatalogWithNameAndPages("Mo", 100);
		if (catalog.getBooks().size() > 0) {
			for (Book b : catalog.getBooks()) {
				assertTrue("The book is not correct", b.getTitle().contains("Mo"));
				assertTrue("The book is not correct", b.getPages() > 100);
			}
		}
	}
}
