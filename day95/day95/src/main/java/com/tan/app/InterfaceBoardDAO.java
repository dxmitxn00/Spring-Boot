package com.tan.app;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterfaceBoardDAO {
	List<BoardDTO> selectAll(BoardDTO bDTO);
	BoardDTO selectOne(int bid);
	boolean insert(BoardDTO bDTO);
	boolean update(BoardDTO bDTO);
	boolean delete(@Param("BID") int bid);
}
