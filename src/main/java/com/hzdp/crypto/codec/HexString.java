package com.hzdp.crypto.codec;

public class HexString {

	public static String convertByte2Hex(byte[] encrpt) {
		StringBuilder sb = new StringBuilder();
		for (byte b : encrpt) {
			int ab = b & 0xFF;
			String hex = Integer.toHexString(ab);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex);
		}
		return sb.toString();
	}
}
