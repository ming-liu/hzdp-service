package com.hzdp.review.entity;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7870372023066054324L;

	private int id;
	private int userId;
	private int referId;
	private int referType;
	private Date addtime;
	// default : 1 ; deleted:0
	private int status;
	private String review;
	private int grade1;
	private int grade2;
	private int grade3;
	// (1:20以下 2:20-25 3:26-30 4:30-39 5:40岁以上)
	private int age;
	// (1:混合皮肤 2:敏感皮肤 3:干性皮肤 4:油性皮肤 5:中性皮肤 )
	private int skin;
	private long ip;
	private int platform;
	
	// TODO to remove,use review image
	private String urls;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReferId() {
		return referId;
	}

	public void setReferId(int referId) {
		this.referId = referId;
	}

	public int getReferType() {
		return referType;
	}

	public void setReferType(int referType) {
		this.referType = referType;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getGrade1() {
		return grade1;
	}

	public void setGrade1(int grade1) {
		this.grade1 = grade1;
	}

	public int getGrade2() {
		return grade2;
	}

	public void setGrade2(int grade2) {
		this.grade2 = grade2;
	}

	public int getGrade3() {
		return grade3;
	}

	public void setGrade3(int grade3) {
		this.grade3 = grade3;
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

	public long getIp() {
		return ip;
	}

	public void setIp(long ip) {
		this.ip = ip;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

}
