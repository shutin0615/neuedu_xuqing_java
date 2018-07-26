 package com.neuedu.entity;

import java.io.Serializable;

/**
 java实体类也称javabean
 1.属性私有
 2.提供有参或无参的构造方法
 3.提供get/set方法
 4.实现序列化接口
 */
public class Product implements Serializable/*实现序列化接口，将数据保存至本地文件系统中*/{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//自动生成的版本号
	private int id;
	private String name;
	private String desc;//商品描述
	private double price;
	private String rule;//商品规格
	private String image;
	private int stock;//库存
	
    public Product() { 
		super();
	}
	
	
    public Product(/*int id,*/ String name, String desc, int price, String rule, String image/*, int stock*/) {
		super();
		//this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
		this.stock = stock;
	}
    public Product(int id, String name, String desc, double price, String rule, String image, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
		this.stock = stock;
	}


	public Product(int id, String name, String desc, int price, String rule, String image/*, int stock*/) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
		this.stock = stock;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double  getPrice() {
		return price;
	}
	public void setPrice(double  price) {
		this.price = price;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", rule=" + rule
				
				+ ", image=" + image + ", stock=" + stock + "]";
	}

	
}
