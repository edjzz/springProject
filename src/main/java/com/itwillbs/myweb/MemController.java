package com.itwillbs.myweb;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberBean;
import com.itwillbs.service.MemService;
import com.itwillbs.service.MemServiceImpl;

@Controller
public class MemController {
	// MemService memService = new MemServiceImpl();
	private MemService memService;
	@Inject
	public void setMemService(MemService memService) {
		this.memService = memService;
	}
	
//	MemController, HomeController 같은 주소 /test 있으면 에러 발생
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		
//		return "test";
//	}
	

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		System.out.println("회원가입");
		return "insertForm";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPost(MemberBean mb) {
		System.out.println("ID: "+mb.getId()+",PASS: "+mb.getPass()+",NAME: "+mb.getName());
		System.out.println("회원가입 처리");
		// 1. 객체 생성 => 3군데 수정 필요
//		MemServiceImpl memServiceImpl = new MemServiceImpl();
//		memServiceImpl.insert();
		// 2. 부모=자식 객체 생성 => 1군 수정 필요 
//		MemService memService = new MemServiceImpl();
//		memService.insert();
		// 3. 부모=자식이 사용 되는 곳 <= 스프링파일 xml 자식 객체생성 필요로 하는 곳을 줌
		//    스프링에서 객체 생성하는 방식 : 의존관계 주입 (DI)
		memService.insert(mb);
		

		return "redirect:login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인");
		return "loginForm";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(MemberBean mb, HttpSession session) {
		System.out.println(mb.getId());
		System.out.println(mb.getPass());
		System.out.println("로그인 처리");
		// 리턴값 MemberBean mb2 = userCheck(mb)
		MemberBean mb2 = memService.userCheck(mb);
		// 아이디 비밀번호 일치하면 mb2 회원정보 모두 가져오기
		if(mb2!=null) {
			// 세션값 생성
			session.setAttribute("id", mb2.getId());
		}
		return "redirect:main";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		System.out.println("메인");
		return "main";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 로그아웃 
		session.invalidate();
		System.out.println("로그아웃 처리");
		return "redirect:main";
	}
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {
		System.out.println("인포");
		MemberBean mb = memService.info((String)session.getAttribute("id"));
		model.addAttribute("mb",mb);
		
		return "info";
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		System.out.println("업데이트");
		MemberBean mb = memService.info((String)session.getAttribute("id"));
		model.addAttribute("mb",mb);
		return "updateForm";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePost(MemberBean mb) {
		
		MemberBean mb2 = memService.userCheck(mb);
		
		if(mb2!=null) {
			memService.update(mb);
		}
		System.out.println("업데이트 완료");
		return "redirect:main";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {

		return "deleteForm";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePost(MemberBean mb, HttpSession session) {
		System.out.println("삭제 완료");
		System.out.println("삭제");
		MemberBean mb2 = memService.userCheck(mb);
		if(mb2!=null) {
			memService.delete(mb.getId());
			session.invalidate();
		}
		return "redirect:main";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		System.out.println("리스트");
		return "list";
	}

}
