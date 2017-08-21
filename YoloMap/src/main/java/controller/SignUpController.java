package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.UserModel;
import service.UserService;

@Controller
public class SignUpController {

	@Autowired
	UserService userService;
	

	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView displaySignUp(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("signUp");
		UserModel loginBean = new UserModel();
		model.addObject("loginBean", loginBean);
		return model;
	}
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView executeSignUp(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")UserModel loginBean)
	{
		ModelAndView model= null;
		try
		{
			boolean isValidUser = userService.signUp(loginBean.getUser_name(), loginBean.getPassword());
			if(isValidUser)
			{
				System.out.println("Sign up Successful");
				request.setAttribute("loginBean", loginBean);
				model = new ModelAndView("login");
			}
			else
			{
				model = new ModelAndView("signUp");
				model.addObject("signUp", loginBean);
				model.addObject("errorMessage", "User is existed");
				request.setAttribute("message", "Invalid credentials!!");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}
}
