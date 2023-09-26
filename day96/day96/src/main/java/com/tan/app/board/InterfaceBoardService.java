package com.tan.app.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface InterfaceBoardService {
	List<BoardDTO> selectAll(BoardDTO boardDTO);
	BoardDTO selectOne(BoardDTO boardDTO);
	boolean insert(BoardDTO boardDTO);
	boolean update(BoardDTO boardDTO);
	boolean delete(BoardDTO boardDTO);
}