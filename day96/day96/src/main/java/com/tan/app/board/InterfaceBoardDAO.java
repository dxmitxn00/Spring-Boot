package com.tan.app.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
interface InterfaceBoardDAO {
	List<BoardDTO> selectAll(BoardDTO boardDTO);
	BoardDTO selectOne(int boardId);
	boolean insert(Map<String, String> map);
	boolean update(Map<String, String> map);
	boolean delete(int boardId);
}