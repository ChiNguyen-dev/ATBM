package com.watch.model;

public class Category {
	private String cateId;
	private String cateName;

	public Category(String cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

}
