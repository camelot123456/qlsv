package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	
	
	public static <T> T toModel(Class<T> tClass, HttpServletRequest req) {
		T object = null;
		try {
			object = (T) tClass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
