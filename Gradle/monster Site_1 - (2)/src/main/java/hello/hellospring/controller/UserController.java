package hello.hellospring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.JdbcMemberRepository;

@Controller
public class UserController {

	private JdbcMemberRepository jdbcRepository;
	
	@Autowired 
	JdbcTemplate jdbc;
	
	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Member member = new Member();
		jdbcRepository = new JdbcMemberRepository(jdbc);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		member.setEmail(email);
		member.setPassword(password);
		
		if(jdbcRepository.login(member))
		{
			session.setAttribute("logoutbutton", "| <a href=\"/logout\">로그아웃</a>");
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			mv.setViewName("main");
		}else
		{
			mv.setViewName("login.html");
		}

		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpSession session)
	{
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.removeAttribute("logoutbutton");
		return "main";
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView("main");
		jdbcRepository = new JdbcMemberRepository(jdbc);
		
		
		
		Member member = new Member();
		
		String name = "";
		String email = "";
		String password = "";

		name = request.getParameter("names");
		email = request.getParameter("email");
		password = request.getParameter("password");

		member.setEmail(email);
		member.setName(name);
		member.setPassword(password);

		jdbcRepository.register(member);

		
		
		return mv;
	}
	
	

	@PostMapping("/")
	public String home(HttpServletRequest request) {
		hello.hellospring.domain.Member member = new Member();
		member.setName(member.getName());

		String name = request.getParameter("names");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		

		return "home";

	}

//    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
//
//        System.out.println("RequestMethod.POST");
//
//        String name = httpServletRequest.getParameter("names");
//        String email = httpServletRequest.getParameter("email");
//        String password = httpServletRequest.getParameter("password");
//
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(password);
//
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/login");
//
//        return mav;
//
//    }

}
