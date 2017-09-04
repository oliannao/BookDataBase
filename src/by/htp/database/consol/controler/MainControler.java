package by.htp.database.consol.controler;

import java.util.Date;

import by.htp.database.consol.view.ConsolOutPut;
import by.htp.database.consol.view.impl.SimplConsolOutPut;
import by.htp.database.domain.vo.Catalog;
import by.htp.database.servise.CatalogService;
import by.htp.database.servise.impl.DefaultCatalogImpl;

public class MainControler {

	public static void main(String[] args) {

		ConsolOutPut outPut = new SimplConsolOutPut();
		CatalogService service = new DefaultCatalogImpl();

		Catalog catalog = service.getCatalog();
		outPut.printCatalog(catalog);

		Catalog catalog1 = service.getCatalog(new Date());
		outPut.printCatalog(catalog1);

		Catalog catalog3 = service.getCatalogWithNameAndPages("Mo", 100);
		outPut.printCatalog(catalog3);

		Catalog catalog2 = service.getCatalogAfterDeletBook(1);
		outPut.printCatalog(catalog2);
		System.out.println();
	}

}
