package com.hhg0104.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hhg0104.entity.Board;
import com.hhg0104.exception.SessionElementException;
import com.hhg0104.service.BoardService;

@RestController
public class BoardController extends CommonController {

	@Autowired
	private BoardService service;

	/**
	 * get all board list of specific user
	 * 
	 * @param session
	 *            HttpSession
	 * @return all board list
	 * @throws SessionElementException
	 *             no login exception
	 */
	@RequestMapping("/boards")
	public List<Board> getBoards(HttpSession session) throws SessionElementException {

		int userIdx = getUserIdx(session);

		return service.getBoards(userIdx);
	}

	/**
	 * get board info
	 * 
	 * @param session
	 *            HttpSession
	 * @param idx
	 *            board index
	 * @return board info
	 * @throws SessionElementException
	 *             no login exception
	 */
	@RequestMapping("/boards/{idx}")
	public Board getBoardInfo(HttpSession session, @PathVariable int idx) throws SessionElementException {

		int userIdx = getUserIdx(session);

		return service.getBoardInfo(idx, userIdx);
	}

	/**
	 * add new board
	 * 
	 * @param session
	 *            HttpSession
	 * @param board
	 *            board info to be added
	 * @throws SessionElementException
	 *             no login exception
	 */
	@RequestMapping(name = "/board", method = RequestMethod.POST)
	public void addBoard(HttpSession session, @RequestBody Board board) throws SessionElementException {

		int userIdx = getUserIdx(session);
		board.setUserIdx(userIdx);

		service.addBoard(board);
	}

	/**
	 * edit existing board
	 * 
	 * @param session
	 *            HttpSession
	 * @param board
	 *            board info to be edited
	 * @throws SessionElementException
	 *             no login exception
	 */
	@RequestMapping(name = "/boards/{idx}", method = RequestMethod.PUT)
	public void editBoard(HttpSession session, @PathVariable int idx, @RequestBody Board board)
			throws SessionElementException {

		int userIdx = getUserIdx(session);
		board.setUserIdx(userIdx);

		service.editBoard(idx, board);
	}

	/**
	 * delete existing board
	 * 
	 * @param session
	 *            HttpSession
	 * @param board
	 *            board info to be edited
	 * @throws SessionElementException
	 *             no login exception
	 */
	@RequestMapping(name = "/boards/{idx}", method = RequestMethod.DELETE)
	public void deleteBoard(HttpSession session, @PathVariable int idx) throws SessionElementException {

		int userIdx = getUserIdx(session);

		service.deleteBoard(idx, userIdx);
	}
}
