package com.hhg0104.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhg0104.entity.Board;
import com.hhg0104.repository.BoardRepository;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardRepository repo;

	/**
	 * get all board list of specific user
	 * 
	 * @param userIdx
	 *            user index
	 * @return board list
	 */
	public List<Board> getBoards(int userIdx) {
		return repo.findByUserIdx(userIdx);
	}

	/**
	 * get board info
	 * 
	 * @param idx
	 *            board index
	 * @param userIdx
	 *            user index
	 * @return board info
	 */
	public Board getBoardInfo(int idx, int userIdx) {
		return repo.findByIdxAndUserIdx(idx, userIdx);
	}

	/**
	 * add new board
	 * 
	 * @param board
	 *            board info to be added
	 */
	public void addBoard(Board board) {
		repo.save(board);
	}

	/**
	 * edit existing board
	 * 
	 * @param idx
	 *            board index
	 * @param board
	 *            board info to be edited
	 */
	@Transactional
	public void editBoard(int idx, Board board) {

		Board boardEntityToBeUpdated = repo.getOne(idx);
		boardEntityToBeUpdated.copyDataForUpdate(board);

		repo.save(boardEntityToBeUpdated);

		// TODO Field list edit logic needs
	}

	/**
	 * delete existing board
	 * 
	 * @param idx
	 *            board index
	 * @param userIdx
	 *            user index
	 */
	public void deleteBoard(int idx, int userIdx) {
		repo.deleteByidxAndUserIdx(idx, userIdx);
	}
}
