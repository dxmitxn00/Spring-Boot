package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service는 Component를 상속받음 => Controller로 꽂아주는 애
@Service
public class BoardService implements InterfaceBoardService{

	@Autowired
	private InterfaceBoardDAO bDAO;
	
	@Override
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return bDAO.selectAll(bDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		return bDAO.selectOne(bDTO.getBid());
	}

	@Override
	public boolean insert(BoardDTO bDTO) {
		return bDAO.insert(bDTO);
	}

	@Override
	public boolean update(BoardDTO bDTO) {
		return bDAO.update(bDTO);
	}

	@Override
	public boolean delete(BoardDTO bDTO) {
		return bDAO.delete(bDTO.getBid());
	}
	
}
