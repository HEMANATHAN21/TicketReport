package ticketreport.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		System.out.println("*****************************");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
}
