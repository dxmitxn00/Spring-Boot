package com.tan.app.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberDTO { // VO
	@NotBlank(message="Null 및 공백 안됨")
	@Size(min=5, max=20, message="memberId값 5이상 20이하")
	private String memberId; // PK
	@NotBlank(message="Null 및 공백 안됨")
	@Size(min=4, max=10, message="memberPw값 4이상 10이하")
	private String memberPw; 
}
