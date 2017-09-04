package by.htp.database.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import by.htp.database.dao.BookDao;
import by.htp.database.domain.entity.Book;

public class BookMySqlDAO implements BookDao {
	private static final String DB_URL = "jdbc:mysql://localhost/librarydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	// протокол, подпротокол, сервер, название базы
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String SQL_SELECT_BOOKS = "select* from book";
	private static final String SQL_SELECT_BOOKS_DATE = "select* from book where date<?";
	private static final String SQL_DELET_BOOK = "delete from book where id=?";
	private static final String SQL_SELECT_BOOKS_NAME_PAGES = "select* from book where title like ? and pages>?";

	@Override
	public List<Book> fetchBooksWithoutDate() {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			PreparedStatement st = con.prepareStatement(SQL_SELECT_BOOKS);

			ResultSet rs = st.executeQuery();
			Book book = null;
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));
				java.util.Date utilDate = new java.util.Date(rs.getDate("date").getTime());
				book.setDate(utilDate);
				books.add(book);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return books;
	}

	@Override
	public List<Book> fetchBooks(Date date) {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			PreparedStatement st = con.prepareStatement(SQL_SELECT_BOOKS_DATE);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			st.setDate(1, sqlDate);
			ResultSet rs = st.executeQuery();
			Book book = null;
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));
				java.util.Date utilDate = new java.util.Date(rs.getDate("date").getTime());
				book.setDate(utilDate);
				books.add(book);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return books;
	}

	/*
	 * public static void main(String[] args) { BookMySqlDAO dao = new
	 * BookMySqlDAO(); dao.fetchBooks(); }
	 */
	@Override
	public Book fetchBook() {
		Book book = new Book();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);

			rs.next();

			book.setId(rs.getInt(1));
			book.setTitle(rs.getString("Title"));
			book.setPages(rs.getInt("pages"));
			java.util.Date utilDate = new java.util.Date(rs.getDate("date").getTime());
			book.setDate(utilDate);
			// System.out.println(id + " " + title + "" + pages);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return book;
	}

	@Override
	public void deletBook(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement st = con.prepareStatement(SQL_DELET_BOOK);
			st.setInt(1, id);
			st.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public List<Book> fetchBooksWithNamePages(String s, int pages) {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			PreparedStatement st = con.prepareStatement(SQL_SELECT_BOOKS_NAME_PAGES);
			st.setString(1, "%" + s + "%");
			st.setInt(2, pages);
			ResultSet rs = st.executeQuery();
			Book book = null;
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));
				java.util.Date utilDate = new java.util.Date(rs.getDate("date").getTime());
				book.setDate(utilDate);
				books.add(book);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return books;
	}

}
