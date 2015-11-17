package com.hzdp.crypto;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {

	private static final String ENCODING_TEXT = "UTF-8";

	private static final String AES_Transform = "AES/CBC/NoPadding";
	private static final String AES_Algrithm = "AES";

	public static byte[] encrpt(byte[] bytes, byte[] key, byte[] iv) throws EncryptionException {
		try {
			Cipher cipher = Cipher.getInstance(AES_Transform);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, AES_Algrithm), new IvParameterSpec(iv));
			return cipher.doFinal(padding(bytes));
		} catch (Exception e) {
			throw new EncryptionException(e.getMessage());
		}
	}

	public static byte[] encrpt(String content, String key, String iv) throws EncryptionException {
		try {
			return encrpt(content.getBytes(ENCODING_TEXT), key.getBytes(ENCODING_TEXT), iv.getBytes(ENCODING_TEXT));
		} catch (UnsupportedEncodingException e) {
			throw new EncryptionException(e.getMessage());
		}
	}

	public static byte[] decrpt(byte[] content, String key, String iv) throws DecryptionException {
		try {
			Cipher cipher = Cipher.getInstance(AES_Transform);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(ENCODING_TEXT), AES_Algrithm), new IvParameterSpec(iv.getBytes(ENCODING_TEXT)));
			return cipher.doFinal(content);
		} catch (Exception e) {
			throw new DecryptionException(e.getMessage());
		}
	}

	public static String decrptToStr(byte[] content, String key, String iv) throws DecryptionException {
		try {
			Cipher cipher = Cipher.getInstance(AES_Transform);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(ENCODING_TEXT), AES_Algrithm), new IvParameterSpec(iv.getBytes(ENCODING_TEXT)));
			byte[] doFinal = cipher.doFinal(content);
			return new String(doFinal, ENCODING_TEXT);
		} catch (Exception e) {
			throw new DecryptionException(e.getMessage());
		}
	}

	public static byte[] padding(byte[] bytes) {
		int mod = bytes.length % 16;
		if (mod > 0) {
			byte[] result = new byte[bytes.length + (16 - mod)];
			System.arraycopy(bytes, 0, result, 0, bytes.length);
			return result;
		}
		return bytes;
	}

	public static void main(String[] args) throws EncryptionException, UnsupportedEncodingException {
		byte[] encrpt = encrpt("abcdefghijklmnopqrstuvwxyz", "D7C6F71A12153EE5", "55C930D827BDABFD");
		byte[] decrpt = decrpt(encrpt, "D7C6F71A12153EE5", "55C930D827BDABFD");
		String decrptToStr = decrptToStr(encrpt, "D7C6F71A12153EE5", "55C930D827BDABFD");
		System.out.println(decrptToStr);
		
		StringBuilder sb = new StringBuilder();
		byte[] bs = new byte[]{49,50,70,65,0,0,0,0,0,0,0,0,0,0};
		for (byte b : encrpt) {
			int ab = b&0xFF;
			String hxStr = Integer.toHexString(ab);
			sb.append(hxStr);
		}
		System.out.println(sb.toString());
		System.out.println(new String(encrpt,"UTF-8").trim());
		// encrpt = encrpt("abcdefghijklmnopqrstuvwxyz".getBytes(ENCODING_TEXT),
		// "testtesttesttest", "1234567812345678");
	}

}
