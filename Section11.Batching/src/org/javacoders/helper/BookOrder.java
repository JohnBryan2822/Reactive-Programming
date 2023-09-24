package org.javacoders.helper;

import org.javacoders.courseUtil.Util;

import com.github.javafaker.Book;

public class BookOrder {
	
	private String title;
	private String author;
	private String category;
	private double price;
	
	public BookOrder() {
		Book book = Util.faker().book();
		this.title = book.title();
		this.author = book.author();
		this.category = book.genre();
		this.price = Double.parseDouble(Util.faker().commerce().price());
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "BookOrder [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price + "]";
	}

}
