package com.hhg0104.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hhg0104.entity.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {

	public Field findByIdxAndUserIdx(int idx, int userIdx);
}
