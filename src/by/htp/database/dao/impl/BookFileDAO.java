package by.htp.database.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import by.htp.database.dao.BookDao;
import by.htp.database.domain.entity.Book;

public class BookFileDAO implements BookDao {
	private static final File file = new File("D:\\1.txt");

	@Override
	public List<Book> fetchBooks(Date date) {
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			while (bf.ready()) {
				book = new Book();
				String line = bf.readLine();
				List<String> list = Arrays.asList(line.split(" "));
				book.setId(Integer.parseInt(list.get(0)));
				book.setTitle(list.get(1));
				book.setPages(Integer.parseInt(list.get(2)));
				DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
				Date datebook = formatter.parse(list.get(3));
				book.setDate(datebook);
				if (datebook.before(date)) {
					books.add(book);
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book fetchBook() {
		Book book = new Book();
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String line = bf.readLine();
			List<String> list = Arrays.asList(line.split(" "));
			book.setId(Integer.parseInt(list.get(0)));
			book.setTitle(list.get(1));
			book.setPages(Integer.parseInt(list.get(2)));
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
			Date date = formatter.parse(list.get(3));
			book.setDate(date);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> fetchBooksWithoutDate() {
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			while (bf.ready()) {
				book = new Book();
				String line = bf.readLine();
				List<String> list = Arrays.asList(line.split(" "));
				book.setId(Integer.parseInt(list.get(0)));
				book.setTitle(list.get(1));
				book.setPages(Integer.parseInt(list.get(2)));
				DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
				Date date = formatter.parse(list.get(3));
				book.setDate(date);
				books.add(book);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void deletBook(int id) {
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			while (bf.ready()) {
				book = new Book();
				String line = bf.readLine();
				List<String> list = Arrays.asList(line.split(" "));
				book.setId(Integer.parseInt(list.get(0)));
				book.setTitle(list.get(1));
				book.setPages(Integer.parseInt(list.get(2)));
				DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
				Date date = formatter.parse(list.get(3));
				book.setDate(date);
				books.add(book);

			}
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			for (int i = 0; i < books.size(); i++) {
				if (books.get(i).getId() != id) {
					String newline = books.get(i).getId() + " " + books.get(i).getTitle() + " "+ books.get(i).getPages()
							+ " " + books.get(i).getDate();
					bw.write(newline + "\n");
				}
			}

		} catch (

		FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Book> fetchBooksWithNamePages(String s, int pages) {
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			while (bf.ready()) {
				book = new Book();
				String line = bf.readLine();
				List<String> list = Arrays.asList(line.split(" "));
				book.setId(Integer.parseInt(list.get(0)));
				book.setTitle(list.get(1));
				book.setPages(Integer.parseInt(list.get(2)));
				DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.US);
				Date date = formatter.parse(list.get(3));
				book.setDate(date);
				if (book.getTitle().contains(s) && book.getPages() > pages) {
					books.add(book);
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

}
