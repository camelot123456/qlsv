package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new HttpUtil(sb.toString());
	}
	
}
