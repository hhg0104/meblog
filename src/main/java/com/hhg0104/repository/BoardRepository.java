package com.hhg0104.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hhg0104.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	List<Board> findByUserIdx(int userIdx);

	Board findByIdxAndUserIdx(int idx, int userIdx);

	void deleteByidxAndUserIdx(int idx, int userIdx);
}
