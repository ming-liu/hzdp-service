package com.hzdp.serialize.json;

import java.io.Serializable;

public class Wrap implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6442164742270624896L;

	protected Object wrapped;
	protected String wrappedType;

	public Wrap() {

	}

	public Wrap(Object src) {
		wrapped = src;
		wrappedType = src.getClass().getName();
	}

	public Object getWrapped() {
		return wrapped;
	}

	public void setWrapped(Object wrapped) {
		this.wrapped = wrapped;
	}

	public String getWrappedType() {
		return wrappedType;
	}

	public void setWrappedType(String wrappedType) {
		this.wrappedType = wrappedType;
	}

}
