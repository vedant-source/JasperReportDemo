package com.japer.pojo;


public class Product {

	private int id;
	private String description;
	private String name;
	private Long price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String description, String name, Long price) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
