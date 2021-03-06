package com.hhg0104.controller;

import javax.servlet.http.HttpSession;

import com.hhg0104.entity.UserInfo;
import com.hhg0104.exception.SessionElementException;

public class CommonController {

	/**
	 * get userinfo from session
	 * 
	 * @param session
	 *            httpsession
	 * @return userInfo
	 * @throws SessionElementException
	 *             no login exception
	 */
	public UserInfo getUserInfo(HttpSession session) throws SessionElementException {

		Object userInfoObj = session.getAttribute("user");
		if (userInfoObj == null || !(userInfoObj instanceof UserInfo)) {
			throw new SessionElementException("you need to login first.");
		}

		return (UserInfo) userInfoObj;
	}

	/**
	 * get user idx info
	 * 
	 * @param session
	 *            HttpSession
	 * @return userIdx
	 * @throws SessionElementException
	 *             no login exception
	 */
	public int getUserIdx(HttpSession session) throws SessionElementException {

		UserInfo userInfo = getUserInfo(session);

		return userInfo.getIdx();
	}
}
