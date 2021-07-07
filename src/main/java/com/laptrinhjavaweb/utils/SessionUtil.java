package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		// TODO Auto-generated constructor stub
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		} 
		return sessionUtil;//kiểm tra xem đổi tượng đó đã khởi tạo hay chưa, nếu rồi thì không cần tao thêm nữa
	}
	
	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest req, String key) {
		req.getSession().removeAttribute(key);
	}
}
