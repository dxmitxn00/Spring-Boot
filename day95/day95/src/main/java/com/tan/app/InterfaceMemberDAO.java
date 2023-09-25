package com.tan.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterfaceMemberDAO {
	List<MemberDTO> selectAll(MemberDTO mDTO);
	MemberDTO selectOne(Map<String, String> map); // ##{param1}
	boolean insert(MemberDTO mDTO);
	boolean update(MemberDTO mDTO);
	boolean delete(MemberDTO mDTO); // #{BID}
}
