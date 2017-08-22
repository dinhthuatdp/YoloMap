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
public class LoginController {

	/*
	@RequestMapping("/login")
    public ModelAndView loginPage() {  
        String message = "This is login page";
        return new ModelAndView("login", "message", message);  
    }
	*/
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("login");
		UserModel loginBean = new UserModel();
		model.addObject("loginBean", loginBean);
		return model;
	}
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")UserModel loginBean)
	{
		ModelAndView model= null;
		try
		{
			boolean isValidUser = userService.isValidUser(loginBean.getUser_name(), loginBean.getPassword());
			if(isValidUser)
			{
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUser_name());
				model = new ModelAndView("welcome");
			}
			else
			{
				model = new ModelAndView("login");
				model.addObject("loginBean", loginBean);
				request.setAttribute("errorMessage", "Login error!!");
				request.setAttribute("message", "Invalid credentials!!");
			}

		}
		catch(Exception e)
		{
			model = new ModelAndView("login");
			model.addObject("loginBean", loginBean);
			request.setAttribute("errorMessage", "Login error!!");
			e.printStackTrace();
		}

		return model;
	}
}
