package com.hzdp.crypto;

public class TokenUtil {

	private static final String key = "07C1F71A22153AE5";
	private static final String iv = "55F930A817BDABFD";

	public static String generateToken(String content) {
		byte[] encrpt = EncryptionUtil.encrpt(content, key, iv);
		return convertByte2Hex(encrpt);
	}

	private static String convertByte2Hex(byte[] encrpt) {
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

	public static String parseToken(String token) {
		char[] charArray = token.toCharArray();
		int length = charArray.length / 2;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = (byte) (char2Byte(charArray[i * 2]) << 4 | char2Byte(charArray[i * 2 + 1]));
		}
		return EncryptionUtil.decrptToStr(bytes, key, iv);
	}

	private static byte char2Byte(char c) {
		if (c >= '0' && c <= '9') {
			return (byte) (c - '0');
		} else {
			return (byte) (c - 'a' + 10);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(parseToken(generateToken("1|234567890|_|abcdefghijklmnopqrstuvwxyz-ABCDEFGHIJKLMNOPQRSTUVWXYZ")));
	}
}
