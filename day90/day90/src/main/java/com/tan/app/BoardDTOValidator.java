package com.tan.app;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BoardDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BoardDTO boardDTO = (BoardDTO)target;
		String content = boardDTO.getContent();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, content, content);
		
		if(content.length() <= 0) {
			System.out.println("로그: content가 Null입니다.");
			errors.reject("content", "content는 공백일 수 없습니다.");
		}
	}

}
