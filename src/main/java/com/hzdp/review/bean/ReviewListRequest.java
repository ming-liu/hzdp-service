package com.hzdp.review.bean;

import java.io.Serializable;

public class ReviewListRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2439489245997435790L;

	private int productId = -1;
	private int productType = -1;
	private int reviewType = -1;
	private int skin = -1;
	private int age = -1;
	private int offset = -1;
	private int pageSize = -1;

}
