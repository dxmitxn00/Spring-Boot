package com.tan.app;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

public interface InterfaceBoardService {
	List<BoardDTO> selectAll(BoardDTO bDTO);
	BoardDTO selectOne(BoardDTO bDTO);
	boolean insert(BoardDTO bDTO);
	boolean update(BoardDTO bDTO);
	boolean delete(BoardDTO bDTO);
}
