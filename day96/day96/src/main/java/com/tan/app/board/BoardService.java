package com.tan.app.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements InterfaceBoardService{
	
	@Autowired
	private InterfaceBoardDAO boardDAO;

	@Override
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		return boardDAO.selectAll(boardDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO boardDTO) {
		return boardDAO.selectOne(boardDTO.getBoardId());
	}

	@Override
	public boolean insert(BoardDTO boardDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", boardDTO.getMemberId());
		map.put("content", boardDTO.getContent());
		return boardDAO.insert(map);
	}

	@Override
	public boolean update(BoardDTO boardDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("content", boardDTO.getContent());
		map.put("memberId", boardDTO.getMemberId());
		return boardDAO.update(map);
	}

	@Override
	public boolean delete(BoardDTO boardDTO) {
		return boardDAO.delete(boardDTO.getBoardId());
	}
}