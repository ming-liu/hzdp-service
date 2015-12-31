package com.hzdp.util;

public class ThreadLocalDemo {

	private static ThreadLocal<String> tl = new ThreadLocal<String>();
	private static ThreadLocal<String> t2 = new ThreadLocal<String>();

	public static void main(String[] args) {
		tl.set("sdf");
		String string = tl.get();
		System.out.println(string);
		string = t2.get();
		System.out.println(string);

	}
}
