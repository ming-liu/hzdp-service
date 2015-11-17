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

	private static byte[] strip(byte[] bytes) {
		int blank = 0;
		for (int i = bytes.length - 1; i >= 0; i--) {
			if (bytes[i] == '\0') {
				blank++;
			} else {
				break;
			}
		}
		byte[] result = new byte[bytes.length - blank];
		System.arraycopy(bytes, 0, result, 0, result.length);
		return result;
	}

	public static byte[] decrpt(byte[] content, String key, String iv) throws DecryptionException {
		try {
			Cipher cipher = Cipher.getInstance(AES_Transform);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(ENCODING_TEXT), AES_Algrithm), new IvParameterSpec(iv.getBytes(ENCODING_TEXT)));
			byte[] withPadding = cipher.doFinal(content);
			byte[] result = strip(withPadding);
			return result;
		} catch (Exception e) {
			throw new DecryptionException(e.getMessage());
		}
	}

	public static String decrptToStr(byte[] content, String key, String iv) throws DecryptionException {
		try {
			byte[] bytes = decrpt(content, key, iv);
			return new String(bytes, ENCODING_TEXT);
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
}
