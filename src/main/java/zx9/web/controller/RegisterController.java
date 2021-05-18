package zx9.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pwchange.bouncy_change;

import zx9.web.dao.UserDao;

import zx9.web.vo.UserVO;

@Controller
public class RegisterController {

	
	
	@Autowired
	UserDao udao;


	
	
	bouncy_change crt = new bouncy_change();
	
	@RequestMapping("/register.do")
	public String register() {

		return "/register";
	}
	@RequestMapping("/register_ok.do")
	public String register_ok(UserVO a,Model m) {
		System.out.println("id"+a.getSid());
		System.out.println("name"+a.getSname());
		System.out.println("pw"+a.getSpw());
		System.out.println("major"+a.getSmajor());
		System.out.println("num"+a.getSnum());
		System.out.println("grade"+a.getSgrade());
		
		try {
		//System.out.println("?");
		
		if(a.getSid()==null||a.getSname()==null||a.getSpw()==null||a.getSmajor()==null||a.getSnum()==null||a.getSgrade()==0)
			{return "/index";}
					
		//System.out.println(a.toString());

		a.setSpw(crt.CryptoSHA3(a.getSpw(), 224));
		udao.register(a);
		return "/register/register_ok";}
		catch(Exception e) {

			e.printStackTrace();
			return "/register/register_ok";
		}
	}
	@RequestMapping("/register_form.do")
	public String register_form() {
		return "/register/registerForm";
	}
	@RequestMapping("/login_form.do")
	public String login_form() {
		return "/register/loginForm";
		
	}	
	@RequestMapping("kakaologin.do")
	public String kakaologin() {
return "/register/kakao";
	}
	
	@RequestMapping("/login_ok.do")
	public String login_ok(UserVO a,Model m,HttpServletRequest request) {
		HttpSession session=request.getSession();

		
		a.setSpw(crt.CryptoSHA3(a.getSpw(), 224));
		boolean isLoginOk=udao.login(a);
		String msg;
		if(isLoginOk) {
			msg="환영 합니다";
			a=udao.getall(a);
			
			session.setAttribute("Sid", a.getSid());
			session.setAttribute("Sgrade", a.getSgrade());
			session.setAttribute("Siscouncil", a.getSiscouncil());
			session.setAttribute("Smajor", a.getSmajor());
			session.setAttribute("Sname", a.getSname());
			session.setAttribute("Snum", a.getSnum());
		
		}else {
			msg="id와 비밀번호를 확인해 주세요";	
			m.addAttribute("key",1);
		}
		m.addAttribute("msg", msg);
		
		return "/register/login_ok";
		
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
	HttpSession session=request.getSession();
	session.invalidate();
	return "/register/logout";	
	}


	
}