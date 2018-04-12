package com.hhg0104.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhg0104.entity.Field;
import com.hhg0104.repository.FieldRepository;

@Service
public class FieldService {

	@Autowired
	private FieldRepository repo;

	public Field getFieldInfo(int idx, int userIdx) {
		return repo.findByIdxAndUserIdx(idx, userIdx);
	}
}