package com.hzdp.cache.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.hzdp.crypto.codec.HexString;

public class CacheObjectUtil {

	public static String persistObject(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.flush();
		byte[] bytes = baos.toByteArray();
		return HexString.convertByte2Hex(bytes);
	}

	public static Object parseObject(String objStr) throws IOException, ClassNotFoundException {
		byte[] bytes = HexString.converHexStr2Bytes(objStr);
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = new ObjectInputStream(bais);
		Object readObject = objectInputStream.readObject();
		return readObject;
	}
	
}
