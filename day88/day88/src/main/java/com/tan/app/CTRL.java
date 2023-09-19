package com.tan.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class CTRL {
	
	@RequestMapping("/") // 루트 요청
	public @ResponseBody String root() {
		return "롬복 예제입니다! :D";
		// VR xxx
		// 문자열 '값' 넘기는 것이 중요
	}
	
	@RequestMapping("/test")
	public String test(VO vo, Model model) {
							// 커맨드 객체
		System.out.println("vo : " + vo);
		model.addAttribute("apple" , vo.getId());
		return "test";
		// /WEB-INF/vies/test.jsp
	}
	
	// 유형1 : request 자체가 notPOJO인 Servlet 객체이기 때문애 무거워서 활용도가 낮음
	@RequestMapping("/test01")
	public String test01(HttpServletRequest request, Model model) {
		model.addAttribute("apple", request.getParameter("id")); // 단일 변수를 보내줄 때 많이 사용
		return "test";
	} 
	
	// 유형2 : 가독성이 커맨드 객체를 사용할 때보다 별로임
	//		  그러나 View랑 Model이 막 적어도 C만 고생하면 되는 코드라 많이 활용함
	@RequestMapping("/test02")
	public String test02(@RequestParam("id")String id, @RequestParam("name")String name, Model model) {
		model.addAttribute("apple", id);
		return "test";
	}
	
	
	// 유형3 : .do 요청이 아닌 url의 파라미터로 값 받아오는 유형
	//		  스트링 부트의 기능을 활용하고자 하는 추세라 많이 이용하고 있음
	@RequestMapping("/test03/{id}/{name}")
	public String test03(@PathVariable String id, @PathVariable String name, Model model) {
		model.addAttribute("apple", id);
		return "test";
	}
}
