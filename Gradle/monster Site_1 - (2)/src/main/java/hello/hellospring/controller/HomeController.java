package hello.hellospring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/")
    public ModelAndView main(HttpServletRequest req,HttpSession session) {
    	ModelAndView mv = new ModelAndView("main");
    	
    	System.out.println(session.getAttribute("email"));
    
    	session.setAttribute("loginbutton","<a href=\"/login.html\">LOGIN</a>");
		session.setAttribute("mypagebutton","<a href=\"/mypage.html\">MYPAGE</a>");  
		
        return mv;
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }
    
    @GetMapping("/mypage.html")
    public String mypage()
    {
    	return "mypage";
    }

    @GetMapping("/sold.html")
    public String sold() {
        return "sold";
    }

    @GetMapping("/main.html")
    public String home() {
        return "main";
    }

    @GetMapping("/fiction.html")
    public String fiction() {
        return "fiction";
    }

    @GetMapping("/fictionin.html")
    public String fictionin() {
        return "fictionin";
    }

    @GetMapping("/board.html")
    public String board() {
        return "board";
    }
    @GetMapping("/signup.html")
    public String signup() {
        return "signup";
    }
}
