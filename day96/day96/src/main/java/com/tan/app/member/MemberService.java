package com.tan.app.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InterfaceMemberService{
	
	@Autowired
	private InterfaceMemberDAO memberDAO;

	@Override
	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		return memberDAO.selectAll(memberDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO memberDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberDTO.getMemberId());
		map.put("memberPw", memberDTO.getMemberPw());
		return memberDAO.selectOne(map);
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberDTO.getMemberId());
		map.put("memberPw", memberDTO.getMemberPw());
		return memberDAO.insert(map);
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberPw", memberDTO.getMemberPw());
		map.put("memberId", memberDTO.getMemberId());
		return memberDAO.update(map);
	}

	@Override
	public boolean delete(MemberDTO memberDTO) {
		return memberDAO.delete(memberDTO.getMemberId());
	}
}