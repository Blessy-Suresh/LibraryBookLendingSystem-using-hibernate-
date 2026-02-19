package com.library.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOK_TBL")
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    private String bookID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "TOTAL_COPIES")
    private int totalCopies;

    @Column(name = "AVAILABLE_COPIES")
    private int availableCopies;

    public Book() {
        // Hibernate requires default constructor
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}





//package com.library.bean;
//
//public class Book {
//	private String bookID ;
//	private String title ;
//	private String author; 
//	private int totalCopies; 
//	private int availableCopies ;
//	public String getBookID() {
//		return bookID;
//	}
//	public void setBookID(String bookID) {
//		this.bookID = bookID;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//	public int getTotalCopies() {
//		return totalCopies;
//	}
//	public void setTotalCopies(int totalCopies) {
//		this.totalCopies = totalCopies;
//	}
//	public int getAvailableCopies() {
//		return availableCopies;
//	}
//	public void setAvailableCopies(int availableCopies) {
//		this.availableCopies = availableCopies;
//	}
//
//}
