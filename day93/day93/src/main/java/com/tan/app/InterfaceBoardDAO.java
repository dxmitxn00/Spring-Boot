package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface InterfaceBoardDAO {
	List<BoardDTO> selectAll(BoardDTO bDTO);
	BoardDTO selectOne(BoardDTO bDTO);
	boolean insert(BoardDTO bDTO);
	boolean update(BoardDTO bDTO);
	boolean delete(BoardDTO bDTO);
}
