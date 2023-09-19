package com.tan.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class CTRL {
	
	@RequestMapping("/")
	public String root() {
		return "test";
	}
	
	// 현재 많이 쓰고 있는 방식 -> VO에서 @한거 가져옴 => 클래스 따로 팔 필요 없음
	@RequestMapping("/test")
	public String test(@Valid VO vo, BindingResult br, Model model) {
		// BindingResult : Validator에 있는 Error 가져오기 위함
		
		if(br.hasErrors()) {
			System.out.println("발생한 에러목록");
			System.out.println(br.getAllErrors());
			
			if(br.getFieldError("id") != null) {// id에서 Error가 발생했다는 의미
				System.out.println(br.getFieldError("id").getDefaultMessage());				
			}
			
			if(br.getFieldError("password") != null) {// password에서 Error가 발생했다는 의미
				System.out.println(br.getFieldError("password").getDefaultMessage());				
			}
		}
		//////
		
		model.addAttribute("apple", vo.getId());
		return "test";
	}
	
	
	/* 초창기 부트, 올드한 방식 => new도 있고 클래스를 따로 파야함
	//////
	VOValidator voV = new VOValidator();
	voV.validate(vo, br); // br은 커맨드 객체 ( 참조 변수 )
	// 반환값 여러가지 받을 수 있음 ==> 여러 에러를 한 번에 반환

	@RequestMapping("/test")
	public String test(@Valid VO vo, BindingResult br, Model model) {
		// BindingResult : Validator에 있는 Error 가져오기 위함
		
		//////
		VOValidator voV = new VOValidator();
		voV.validate(vo, br); // br은 커맨드 객체 ( 참조 변수 )
							  // 반환값 여러가지 받을 수 있음 ==> 여러 에러를 한 번에 반환
		if(br.hasErrors()) {
			System.out.println("발생한 에러목록");
			System.out.println(br.getAllErrors());
			
			if(br.getFieldError("id") != null) {// id에서 Error가 발생했다는 의미
				System.out.println(br.getFieldError("id").getCode());				
			}

			if(br.getFieldError("password") != null) {// password에서 Error가 발생했다는 의미
				System.out.println(br.getFieldError("password").getCode());				
			}
		}
		//////
		
		model.addAttribute("apple", vo.getId());
		return "test";
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder wdb) {
		wdb.setValidator(new VOValidator());
	}
	*/
}
