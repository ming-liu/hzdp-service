package com.hzdp.serialize;

public interface Serializer {

	String serialize(Object src) throws SerializeException;

	Object deserialize(String input) throws SerializeException;

}
