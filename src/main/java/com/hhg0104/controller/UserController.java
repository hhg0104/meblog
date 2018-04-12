package com.hhg0104.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhg0104.entity.UserInfo;

@RestController
public class UserController {

	@RequestMapping("/user/login")
	public UserInfo getUserInfo(String email, String password) {
		return null;
	}
}
