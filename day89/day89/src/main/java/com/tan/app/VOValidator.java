package com.tan.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검사할 객체의 클래스 정보를 반환
		return VO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { // Errors errors -> 커맨드객체임 ( 참조변수 )
		// target : 유효성 검사할 객체
		// errors : 검증이 통과되지 못한 경우, 왜 통과가 안되었는지를 반환
		VO vo = (VO)target; // 다운캐스팅
		String id = vo.getId();
		String password = vo.getPassword();

		// Null만 errors 처리
		ValidationUtils.rejectIfEmpty(errors, id, id, null, id);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, password, password);
		
		// id가 5글자 이하 일 수 없도록 에러 추가
		if(id.length() <= 5) {
			System.out.println("로그: id값이 5글자 이하입니다.");
			errors.reject("id", "id 5글자 이하");
		}

		
		// 부트에서 지원해주는 Null과 공백을 처리해주는 메서드 -> 로그는 안찍어줌
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, id, id);
		
//		if(id == null || id.isEmpty() || id.isBlank() || id.equals("") || id.trim().isBlank()) {
//			System.out.println("로그: id값이 올바르지 않습니다.");
//			errors.reject("id", "id값 없음");
//		}
		

		
//		String password = vo.getPassword();
//		if(password == null || password.isEmpty() || password.isBlank() || password.equals("") || password.trim().isBlank()) {
//			System.out.println("로그: password값이 올바르지 않습니다.");
//			errors.reject("password", "password값 없음");
//		}
		
	}

}
