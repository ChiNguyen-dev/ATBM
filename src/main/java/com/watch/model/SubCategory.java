package com.watch.model;

public class SubCategory {
	private String subCateId;
	private String subCateName;
	private String cateId;
	public SubCategory(String subCateId, String subCateName, String cateId) {
		super();
		this.subCateId = subCateId;
		this.subCateName = subCateName;
		this.cateId = cateId;
	}
	public String getSubCateId() {
		return subCateId;
	}
	public void setSubCateId(String subCateId) {
		this.subCateId = subCateId;
	}
	public String getSubCateName() {
		return subCateName;
	}
	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	@Override
	public String toString() {
		return "SubCategory [subCateId=" + subCateId + ", subCateName=" + subCateName + ", cateId=" + cateId + "]";
	}
	
	
}
