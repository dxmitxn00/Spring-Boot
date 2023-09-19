package com.tan.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MeberDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MemberDTO memberDTO = (MemberDTO)target;
		String memberId = memberDTO.getMemberId();
		String memberPw = memberDTO.getMemberPw();
		
		ValidationUtils.rejectIfEmpty(errors, memberId, memberId, null, memberId);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, memberPw, memberPw);
		
		if(memberId.length() <= 4 || memberId.length() >= 20) {
			System.out.println("로그: memberId값이 4글자 이하 21글자 이상입니다.");
			errors.reject("memberId", "memberId값은 5글자 이상 20글자 이하이어야 합니다.");
		}

		if(memberPw.length() <= 3 || memberPw.length() >= 11) {
			System.out.println("로그: membePwd값이 3글자 이하 11글자 이상입니다.");
			errors.reject("memberPw", "memberPw값은 4글자 이상 10글자 이하이어야 합니다.");
		}
	}

}
