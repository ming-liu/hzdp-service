package com.hzdp.review.bean;

import java.io.Serializable;

public class ReviewResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -711920290781914378L;

	public static int ResponseTypeOK = 1;// 1:成功
	public static int ResponseTypeTooMuch = 2;// 2:评论太频繁,需要输入图形验证码
	public static int ResponseTypeLoginRequired = 3;// 3:未登录
	public static int ResponseTypeLengthDismatched = 4;// 3:点评内容长度不符合要求

	private int responseType = ResponseTypeOK;
	private int reviewId;

	public int getResponseType() {
		return responseType;
	}

	public void setResponseType(int responseType) {
		this.responseType = responseType;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public boolean isSuccess() {
		return responseType == ResponseTypeOK;
	}

}
