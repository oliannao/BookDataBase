package by.htp.database.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import by.htp.database.domain.entity.Book;

public class Catalog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7370582999609687994L;
	private String title;
	private Date dataCreation;
	private List<Book> books;

	public Catalog(String title, Date dataCreation, List<Book> books) {
		super();
		this.title = title;
		this.dataCreation = dataCreation;
		this.books = books;
	}

	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDataCreation() {
		return dataCreation;
	}

	public void setDataCreation(Date dataCreation) {
		this.dataCreation = dataCreation;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCreation == null) ? 0 : dataCreation.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalog other = (Catalog) obj;
		if (dataCreation == null) {
			if (other.dataCreation != null)
				return false;
		} else if (!dataCreation.equals(other.dataCreation))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Catalog [title=" + title + ", dataCreation=" + dataCreation
				+ "]";
	}

}
