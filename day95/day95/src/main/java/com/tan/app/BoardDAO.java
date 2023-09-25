package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SELECTALL = "SELECT BOARD_ID, MEMBER_ID, CONTENT FROM BOARD;";
	private final String SELECTONE = "SELECT BOARD_ID, MEMBER_ID, CONTENT FROM BOARD WHERE BOARD_ID = ?;";
	private final String INSERT = "INSERT INTO BOARD (MEMBER_ID, CONTENT) VALUES(?,?);";
	private final String UPDATE = "UPDATE BOARD SET CONTENT = ? WHERE BOARD_ID = ?;";
	private final String DELETE = "DELETE FROM BOARD WHERE BOARD_ID = ?;";
	
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	public BoardDTO selectOne(BoardDTO bDTO) {
		Object[] args= { bDTO.getBid() };
		return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	public boolean insert(BoardDTO bDTO) {
		int result=jdbcTemplate.update(INSERT, bDTO.getMid(), bDTO.getContent());
		return result>0 ? true : false;
	}
	public boolean update(BoardDTO bDTO) {
		int result=jdbcTemplate.update(UPDATE, bDTO.getContent(), bDTO.getBid());
		return result>0 ? true : false;
	}
	public boolean delete(BoardDTO bDTO) {
		int result=jdbcTemplate.update(DELETE, bDTO.getBid());
		return result>0 ? true : false;
	}

}
