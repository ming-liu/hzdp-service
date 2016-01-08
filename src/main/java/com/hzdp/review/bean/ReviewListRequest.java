package com.hzdp.review.bean;

import java.io.Serializable;

public class ReviewListRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2439489245997435790L;

	private int productId;
	private int productType;
	private int reviewType;
	private int skin;
	private int age;
	private int offset;
	private int pageSize;

	public int getProductId() {
		return productId;
	}

	public int getProductType() {
		return productType;
	}

	public int getReviewType() {
		return reviewType;
	}

	public int getSkin() {
		return skin;
	}

	public int getAge() {
		return age;
	}

	public int getOffset() {
		return offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public void setReviewType(int reviewType) {
		this.reviewType = reviewType;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
