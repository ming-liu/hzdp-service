package com.hzdp.util;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;

public class CharUtils {

	public static void main(String[] args) {
		String filterEmoticon = filterEmoticon("12😃34好的3lk23sdf都是12😃3上到");
		System.out.println(filterEmoticon);
		System.out.println(checkEmoticon("12😃34好的3l"));
	}

	public static String replaceScriptTag(String str) {
		String result = str.replace("<", "〈");
		result = result.replace(">", "〉");
		return result;
	}

	public static boolean checkEmoticon(String origin) {
		if (StringUtils.isEmpty(origin)) {
			return false;
		}
		byte[] originBytes = origin.getBytes();
		for (int i = 0; i < originBytes.length; i++) {
			if ((originBytes[i] & 0xF8) == 0xF0) {
				return true;
			}
		}
		return false;
	}

	public static String filterEmoticon(String origin) {
		if (origin == null || origin.isEmpty()) {
			return origin;
		}
		byte[] originBytes = origin.getBytes(Charset.forName("UTF-8"));
		byte[] filted = filter(originBytes);
		if (originBytes == filted) {
			return origin;
		} else {
			return new String(filted);
		}
	}

	private static byte[] filter(byte[] originBytes) {
		byte[] newBytes = null;
		int byte4Count = 0;
		for (int i = 0; i < originBytes.length; i++) {
			if ((originBytes[i] & 0xF8) == 0xF0) {
				if (newBytes == null) {
					newBytes = new byte[originBytes.length - 4];
					// 首次copy
					for (int j = 0; j < i; j++) {
						newBytes[j] = originBytes[j];
					}
				}
				i += 3;
				byte4Count++;
				continue;
			}

			if (newBytes != null) {
				newBytes[i - byte4Count * 4] = originBytes[i];
			}
		}

		return newBytes == null ? originBytes : newBytes;
	}
}
