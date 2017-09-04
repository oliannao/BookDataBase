package by.htp.database.servise;

import java.util.Date;

import by.htp.database.domain.vo.Catalog;

public interface CatalogService {
	public Catalog getCatalog();

	public Catalog getCatalog(Date date);

	public Catalog getCatalogAfterDeletBook(int id);

	public Catalog getCatalogWithNameAndPages(String s, int pages);
}
