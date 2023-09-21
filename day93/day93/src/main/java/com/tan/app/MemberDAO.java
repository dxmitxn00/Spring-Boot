package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements InterfaceMemberDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; // 의존관계(멤버변수)
	
	// 응집도를 높여줌
	private final String SELECTONE = "SELECT MEMBER_ID, MEMBER_PW FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?;";
	private final String INSERT = "INSERT INTO MEMBER (MEMBER_ID, MEMBER_PW) VALUES(?,?);";
	private final String UPDATE = "UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ?;";
	private final String DELETE = "DELETE FROM MEMBER WHERE MEMBER_ID = ?;";
	
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return null;
	}
	public MemberDTO selectOne(MemberDTO mDTO) { // 예외처리 미루기
		Object[] args= { mDTO.getMid(), mDTO.getMpw() };
		return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	public boolean insert(MemberDTO mDTO) {
		int result=jdbcTemplate.update(INSERT, mDTO.getMid(), mDTO.getMpw());
		return result>0 ? true : false;
	}
	public boolean update(MemberDTO mDTO) {
		int result=jdbcTemplate.update(UPDATE, mDTO.getMpw(), mDTO.getMid());
		return result>0 ? true : false;
	}
	public boolean delete(MemberDTO mDTO) {
		int result=jdbcTemplate.update(DELETE, mDTO.getMid());
		return result>0 ? true : false;
	}

}
