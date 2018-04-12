package com.hhg0104.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hhg0104.entity.Field;
import com.hhg0104.exception.SessionElementException;
import com.hhg0104.service.FieldService;

@RestController
public class FieldController extends CommonController {

	@Autowired
	private FieldService service;

	/**
	 * get field info
	 * 
	 * @param session
	 *            HttpSession
	 * @param idx
	 *            field idx
	 * @return field info
	 * @throws SessionElementException
	 *             no login exception
	 */
	@RequestMapping("/fields/{idx}")
	public Field getFieldInfo(HttpSession session, @PathVariable int idx) throws SessionElementException {

		int userIdx = getUserIdx(session);

		return service.getFieldInfo(idx, userIdx);
	}

}
