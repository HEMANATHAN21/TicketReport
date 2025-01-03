package ticketreport.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ticketreport.springmvc.dao.ProductivityDao;
import ticketreport.springmvc.dao.TicketDao;
import ticketreport.springmvc.dao.UserDao;
import ticketreport.springmvc.dto.TicketDto;
import ticketreport.springmvc.dto.UserDto;

@Controller
public class AppController 
{
	@Autowired
	UserDao userDao;
	@Autowired
	ProductivityDao productivityDao;
	@Autowired
	TicketDao ticketDao;
	
//	@RequestMapping("/test")
//	public void test(HttpServletResponse resp) throws IOException
//	{
//		PrintWriter pw = resp.getWriter();
//		pw.print("Flyesr_Solo");
//	}
	
	@RequestMapping("/signup")
	public ModelAndView signUp()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",new UserDto());
		mv.setViewName("signUP.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute UserDto user)
	{
		userDao.saveUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("message", "SignUp Successfull");
		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signIn(@RequestParam String email, @RequestParam String password)
	{
		UserDto user = userDao.findByMail(email);
		if(user != null)
		{
			System.out.println(user.getUserMail());
			if(user.getUserPassword().equals(password))
			{
				System.err.println(user.getUserPassword());
				System.out.println(user);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("home.jsp");
				mv.addObject("userData",user);
				mv.addObject("message", "Login successfull");
				return mv;
			}
			return new ModelAndView("signin.jsp");
		}
		return new ModelAndView("signin.jsp");
		
	}
}
