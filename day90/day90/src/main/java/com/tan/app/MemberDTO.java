package com.tan.app;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberDTO { // VO
	@NotNull(message="memberId값 Null")
	@NotEmpty(message="memberId값 Empty")
	@Size(min=5, max=20, message="memberId값 5이상 20이하")
	private String memberId; // PK
	@NotNull(message="memberPw값 Null")
	@NotEmpty(message="memberPw값 Empty")
	@Size(min=4, max=10, message="memberPw값 4이상 10이하")
	private String memberPw; 
}
