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

	public static byte[] converHexStr2Bytes(String token) {
		char[] charArray = token.toCharArray();
		int length = charArray.length / 2;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte) (char2Byte(charArray[i * 2]) << 4 | char2Byte(charArray[i * 2 + 1]));
		}
		return bytes;
	}

	private static byte char2Byte(char c) {
		if (c >= '0' && c <= '9') {
			return (byte) (c - '0');
		} else {
			return (byte) (c - 'a' + 10);
		}
	}
}
