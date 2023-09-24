package org.javacoders.assignment;

import org.javacoders.courseUtil.Util;

public class PurchaseOrder {
	
	private String item;
	private double price;
	private String category;
	
	public PurchaseOrder() {
		this.item = Util.faker().commerce().productName();
		this.category = Util.faker().commerce().department();
		this.price = Double.parseDouble(Util.faker().commerce().price());
	}

	public String getItem() {
		return item;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [item=" + item + ", price=" + price + ", category=" + category + "]";
	}

}
