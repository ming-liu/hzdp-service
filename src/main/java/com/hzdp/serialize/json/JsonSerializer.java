package com.hzdp.serialize.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzdp.serialize.SerializeException;
import com.hzdp.serialize.Serializer;

public class JsonSerializer implements Serializer {

	@Override
	public String serialize(Object src) throws SerializeException {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		try {
			result = mapper.writeValueAsString(new Wrap(src));
		} catch (JsonProcessingException e) {
			throw new SerializeException(e);
		}
		return result;
	}

	@Override
	public Object deserialize(String input) throws SerializeException {
		String[] split = input.split(",\"wrappedType\":\"");
		ObjectMapper mapper = new ObjectMapper();
		Object result = null;
		try {
			String wrapped = split[0].substring(11);
			String type = split[1].substring(0, split[1].length() - 2);
			result = mapper.readValue(wrapped, Class.forName(type));
		} catch (Exception e) {
			throw new SerializeException(e);
		}
		return result;
	}

}
