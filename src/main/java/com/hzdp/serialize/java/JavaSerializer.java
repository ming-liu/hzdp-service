package com.hzdp.serialize.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.hzdp.crypto.codec.HexString;
import com.hzdp.serialize.SerializeException;
import com.hzdp.serialize.Serializer;

public class JavaSerializer implements Serializer {

	@Override
	public String serialize(Object src) throws SerializeException {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			try {
				oos.writeObject(src);
				oos.flush();
			} finally {
				oos.close();
			}
			byte[] bytes = baos.toByteArray();
			return HexString.convertByte2Hex(bytes);
		} catch (Throwable t) {
			throw new SerializeException(t);
		}
	}

	@Override
	public Object deserialize(String input) {
		byte[] bytes = HexString.converHexStr2Bytes(input);
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = null;
		Object readObject = null;
		try {
			try {
				objectInputStream = new ObjectInputStream(bais);
				readObject = objectInputStream.readObject();
			} finally {
				objectInputStream.close();
			}
		} catch (Throwable e) {
			throw new SerializeException(e);
		}
		return readObject;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public <T> T deserialize(String input, Class<T> clazz) throws
	// SerializeException {
	// Object deserialize = deserialize(input);
	// T result = null;
	// try {
	// result = (T) deserialize;
	// } catch (Exception e) {
	// throw new SerializeException(e);
	// }
	// return result;
	// }

}
