package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	// 의존관계 ( 멤버변수 )
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL문 : 상단에 따로 배치 -> 응집도를 높여줌
	// final이 붙으면 값이 변하지 않는 상수이기 때문에 변수 이름을 대문자로 함
	// 대문자 : 상수 이거나 SQL 구문임
	private final String SELECTALL = "SELECT BOARD_ID, MEMBER_ID, CONTENT FROM BOARD;";
	private final String SELECTONE = "SELECT BOARD_ID, MEMBER_ID, CONTENT FROM BOARD WHERE BOARD_ID = ?;";
	private final String INSERT = "INSERT INTO BOARD (MEMBER_ID, CONTENT) VALUES(?,?);";
	private final String UPDATE = "UPDATE BOARD SET CONTENT = ? WHERE BOARD_ID = ?;";
	private final String DELETE = "DELETE FROM BOARD WHERE BOARD_ID = ?;";
	
	// 목록 출력
	public List<BoardDTO> selectAll(BoardDTO boardDTO){
		// 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	// 글 상세
	public BoardDTO selectOne(BoardDTO boardDTO) {
		Object[] args = { boardDTO.getBoardId() };
		return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	// 글 작성
	public boolean insert(BoardDTO boardDTO) {
		int result = jdbcTemplate.update(INSERT, boardDTO.getMemberId(), boardDTO.getContent());
		
		if(result <=0) {
			return false;
		}
		return true;
	}
	
	// 글 수정
	public boolean update(BoardDTO boardDTO) {
		int result = jdbcTemplate.update(UPDATE, boardDTO.getContent(), boardDTO.getBoardId());
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	// 글 삭제
	public boolean delete(BoardDTO boardDTO) {
		int result = jdbcTemplate.update(DELETE, boardDTO.getBoardId());
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
}
