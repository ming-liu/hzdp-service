package com.hzdp.review.bean;

import java.io.Serializable;

public class ReviewRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2132004001477134657L;

	private int productId;
	private int productType;
	private int userId;
	private String ip;
	private int grade;
	private int age;
	private int skin;
	private String[] urls;
	private String info;
	private int platform;
	private boolean captchaChecked = false;
	private int reviewType;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public String[] getUrls() {
		return urls;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public boolean isCaptchaChecked() {
		return captchaChecked;
	}

	public void setCaptchaChecked(boolean captchaChecked) {
		this.captchaChecked = captchaChecked;
	}

	public int getReviewType() {
		return reviewType;
	}

	public void setReviewType(int reviewType) {
		this.reviewType = reviewType;
	}

}
