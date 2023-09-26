package com.tan.app.member;

import java.util.List;

public interface InterfaceMemberService {
	List<MemberDTO> selectAll(MemberDTO MemberDTO);
	MemberDTO selectOne(MemberDTO MemberDTO);
	boolean insert(MemberDTO MemberDTO);
	boolean update(MemberDTO MemberDTO);
	boolean delete(MemberDTO MemberDTO);
}