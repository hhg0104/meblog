package com.hhg0104.util;

import javax.servlet.http.HttpSession;

import com.hhg0104.exception.SessionElementException;

public class SessionUtils {

	private static final String FORMAT_SESSION_NO_KEY = "There is no key named %s";

	/**
	 * get session value
	 * 
	 * @param session
	 *            HttpSession
	 * @param key
	 *            key string
	 * @return value object
	 * @throws SessionElementException
	 *             if the value is null, the exception will be threw
	 */
	public static Object getValue(HttpSession session, String key) throws SessionElementException {

		Object valueObj = session.getAttribute(key);
		if (valueObj == null) {
			String message = String.format(FORMAT_SESSION_NO_KEY, key);
			throw new SessionElementException(message);
		}

		return valueObj;
	}
}
