package com.tan.app;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

public interface InterfaceMemberService {
	List<MemberDTO> selectAll(MemberDTO mDTO);
	MemberDTO selectOne(MemberDTO mDTO);
	boolean insert(MemberDTO mDTO);
	boolean update(MemberDTO mDTO);
	boolean delete(MemberDTO mDTO);
}
