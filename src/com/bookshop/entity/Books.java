package com.bookshop.entity;


public class Books {

	//图书id
	private Integer id;
	//图书名称
	private String bookName;
	//图书价格
	private String bookPrice;
	//图书图片
	private String image;
	//库存数量
	private Integer stock;
	
	//购买数量
	private Integer count;
	
	public Books() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
