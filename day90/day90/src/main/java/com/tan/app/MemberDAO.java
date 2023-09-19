package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL문
	private final String SELECTONE = "SELECT MEMBER_ID, MEMBER_PW FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?;";
	private final String INSERT = "INSERT INTO MEMBER (MEMBER_ID, MEMBER_PW) VALUES(?,?);";
	private final String UPDATE = "UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ?;";
	private final String DELETE = "DELETE FROM MEMBER WHERE MEMBER_ID = ?;";
	
	// 기능 없음
	public List<MemberDTO> selectAll(MemberDTO memberDTO){
		return null;
	}
	
	// 로그인
	public MemberDTO selectOne(MemberDTO memberDTO) {
		try {
	        Object[] args = { memberDTO.getMemberId(), memberDTO.getMemberPw() };
	        MemberDTO result = jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	        
	        return result; // 레코드가 존재하면 반환
	        
	    } catch (EmptyResultDataAccessException e) {
	        return null; // 레코드가 없으면 null 반환
	    }
	}
	
	// 회원가입
	public boolean insert(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(INSERT, memberDTO.getMemberId(), memberDTO.getMemberPw());
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	// 비밀번호 변경
	public boolean update(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(UPDATE, memberDTO.getMemberPw(), memberDTO.getMemberId());
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
	// 회원탈퇴
	public boolean delete(MemberDTO memberDTO) {
		int result = jdbcTemplate.update(DELETE, memberDTO.getMemberId());
		
		if(result <= 0) {
			return false;
		}
		return true;
	}
	
}
