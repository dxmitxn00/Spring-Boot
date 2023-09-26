package com.tan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tan.app.board.BoardDTO;
import com.tan.app.board.InterfaceBoardService;
import com.tan.app.member.InterfaceMemberService;
import com.tan.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CTRL {
	
	@Autowired
	private InterfaceMemberService memberService;
	@Autowired
	private InterfaceBoardService boardService;

	// 메인 페이지 이동
	@RequestMapping("/")
	public String root(BoardDTO boardDTO, Model model) {
		List<BoardDTO> boardDatas= boardService.selectAll(boardDTO);
		System.out.println("로그: "+boardDatas);
		model.addAttribute("boardDatas", boardDatas);
		return "main";
	}

	//======================== Member Controller =========================== 

	// 로그인
	@RequestMapping("/login")
	public String login(MemberDTO memberDTO, Model model, HttpSession session) {
		if(memberService.selectOne(memberDTO) != null) { // selectOne한 회원이 있으면
			session.setAttribute("sessionMemberId", memberDTO.getMemberId()); // 세션에 mid 저장
		}

		// 유효성 검사 : 로그인 실패
		else {
			model.addAttribute("msg", "로그인 실패ㅜ");
			model.addAttribute("path", "/");
			return "alert";
		}

		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionMemberId");
		return "redirect:/";
	}

	// 회원가입 페이지 이동
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupPage() {
		return "signup";
	}

	// 회원가입
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model) {

		// 유효성 검사
		if(bindingResult.hasErrors()) {
			System.out.println("발생한 에러목록 )");
			System.out.println(bindingResult.getAllErrors());

			// memberId Error
			if(bindingResult.getFieldError("memberId") != null) {
				System.out.println(bindingResult.getFieldError("memberId").getDefaultMessage());
				model.addAttribute("msg", "ID는 5글자 이상 20글자 이하이어야 합니다.");
				model.addAttribute("path", "signup");
				return "alert";
			}

			// memberPw Error
			if(bindingResult.getFieldError("memberPw") != null) {
				System.out.println(bindingResult.getFieldError("memberPw").getDefaultMessage());
				model.addAttribute("msg", "비밀번호는 4글자 이상 10글자 이하이어야 합니다.");
				model.addAttribute("path", "signup");
				return "alert";
			}
		}

		if(memberService.insert(memberDTO)) {
			model.addAttribute("msg", "회원가입 성공! :D");
			model.addAttribute("path", "/");
			return "alert";
		}
		return  "redirect:signup";
	}

	// 마이페이지 이동
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}

	// 비밀번호 변경
	@RequestMapping("/updatePw")
	public String updatePw(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model) {
		// 유효성 검사
		if(bindingResult.hasErrors()) {
			System.out.println("발생한 에러목록 )");
			System.out.println(bindingResult.getAllErrors());

			// memberPw Error
			if(bindingResult.getFieldError("memberPw") != null) {
				System.out.println(bindingResult.getFieldError("memberPw").getDefaultMessage());
				model.addAttribute("msg", "비밀번호는 4글자 이상 10글자 이하이어야 합니다.");
				model.addAttribute("path", "mypage");
				return "alert";
			}
		}
		if(memberService.update(memberDTO)) {
			model.addAttribute("msg", "비밀번호 변경 성공! 다시 로그인해주세요:)");
			model.addAttribute("path", "logout");
			return "alert";
		}
		return "redirect:mypage";
	}

	// 회원탈퇴
	@RequestMapping("/deleteMember")
	public String deleteMember(MemberDTO memberDTO, Model model) {
		if(memberService.delete(memberDTO)) {
			model.addAttribute("msg", "회원탈퇴 성공!");
			model.addAttribute("path", "logout");
			return "alert";
		}
		return "redirect:mypage";
	}

	//======================== Board Controller =========================== 

	// 글 작성
	@RequestMapping("/insertBoard")
	public String insertBoard(@Valid BoardDTO boardDTO, BindingResult bindingResult, Model model) {

		// 유효성 검사
		if(bindingResult.hasErrors()) {
			System.out.println("발생한 에러목록");
			System.out.println(bindingResult.getAllErrors());

			// 글 내용 Error
			if(bindingResult.getFieldError("content") != null) {
				System.out.println(bindingResult.getFieldError("content").getDefaultMessage());
				model.addAttribute("msg", "글 내용을 작성해주세요!");
				model.addAttribute("path", "/");
				return "alert";
			}
		}
		
		if(boardService.insert(boardDTO)) {
			model.addAttribute("msg", "글 작성 성공!");
			model.addAttribute("path", "/");
			return "alert";
		}
		return "redirect:/";
	}

	// 글 상세페이지 이동
	@RequestMapping("/board")
	public String board(BoardDTO boardDTO, Model model, HttpSession session) {
		boardDTO = boardService.selectOne(boardDTO);
		model.addAttribute("boardData", boardDTO);
		return "board";
	}

	// 글 수정
	@RequestMapping("/updateBoard")
	public String updateboard(@Valid BoardDTO boardDTO, BindingResult bindingResult, Model model) {
		// 유효성 검사
		if(bindingResult.hasErrors()) {
			System.out.println("발생한 에러목록");
			System.out.println(bindingResult.getAllErrors());
			
			// 글 내용 Error
			if(bindingResult.getFieldError("content") != null) {
				System.out.println(bindingResult.getFieldError("content").getDefaultMessage());
				model.addAttribute("msg", "글 내용을 작성해주세요!");
				model.addAttribute("path", "/");
				return "alert";
			}
		}
		
		if(boardService.update(boardDTO)) {
			model.addAttribute("msg", "글 수정 성공!");
			model.addAttribute("path", "/");
			return "alert";
		}
		return "redirect:/";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardDTO boardDTO, Model model) {
		if(boardService.delete(boardDTO)) {
			model.addAttribute("msg", "글 삭제 성공!");
			model.addAttribute("path", "/");
			return "alert";
		}
		return "redirect:/";
	}
}
