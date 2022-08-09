package com.bean;

import java.util.HashSet;
import java.util.Set;

public class CategoryBean {

	private Integer categoryId;
	private String categoryName;
	
	Set<ProductBean> products=new HashSet<ProductBean>();

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductBean> products) {
		this.products = products;
	}
	
	
	
}
