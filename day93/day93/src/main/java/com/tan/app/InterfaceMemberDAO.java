package com.tan.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface InterfaceMemberDAO {
	List<MemberDTO> selectAll(MemberDTO mDTO);
	MemberDTO selectOne(MemberDTO mDTO);
	boolean insert(MemberDTO mDTO);
	boolean update(MemberDTO mDTO);
	boolean delete(MemberDTO mDTO);
}
