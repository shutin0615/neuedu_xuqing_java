 package com.neuedu.entity;

import java.io.Serializable;

/**
 javaʵ����Ҳ��javabean
 1.����˽��
 2.�ṩ�вλ��޲εĹ��췽��
 3.�ṩget/set����
 4.ʵ�����л��ӿ�
 */
public class Product implements Serializable/*ʵ�����л��ӿڣ������ݱ����������ļ�ϵͳ��*/{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//�Զ����ɵİ汾��
	private int id;
	private String name;
	private String desc;//��Ʒ����
	private double price;
	private String rule;//��Ʒ���
	private String image;
	private int stock;//���
	
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
