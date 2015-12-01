package com.hzdp.util;

import java.io.UnsupportedEncodingException;

import com.hzdp.crypto.codec.HexString;

public class Demo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "hello";
		String b = "中国";
		byte[] bytes = b.getBytes("UTF-8");
		byte[] bytes2= new byte[bytes.length-1];
		System.arraycopy(bytes, 0, bytes2, 0, bytes.length-1);
		
		String convertByte2Hex = HexString.convertByte2Hex(bytes);
		char c = 'a';
		byte d = (byte)c;
		char x = (char)255;
		System.out.println(convertByte2Hex);
		
		for (int i = 0; i < 256; i++) {
			if(i%16==0) {
				System.out.println();
			}
			System.out.print((char)i);
		}
	}
}
