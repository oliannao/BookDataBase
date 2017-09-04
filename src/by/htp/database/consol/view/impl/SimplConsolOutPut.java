package by.htp.database.consol.view.impl;

import by.htp.database.consol.view.ConsolOutPut;
import by.htp.database.domain.entity.Book;
import by.htp.database.domain.vo.Catalog;

public class SimplConsolOutPut implements ConsolOutPut {

	@Override
	public void printCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		if (catalog != null) {
			System.out.println("Catalog titol:" + catalog.getTitle());
			System.out.println("Catalog date:" + catalog.getDataCreation());
			for (Book book : catalog.getBooks()) {
				System.out.println(book);
			}
		}
	}
}
