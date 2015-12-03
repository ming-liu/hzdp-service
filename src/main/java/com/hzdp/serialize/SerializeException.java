package com.hzdp.serialize;

public class SerializeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -445581451106739681L;

	public SerializeException() {
		super();
	}

	public SerializeException(String msg) {
		super(msg);
	}

	public SerializeException(Throwable throwable) {
		super(throwable);
	}
}
