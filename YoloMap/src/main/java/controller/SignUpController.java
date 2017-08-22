package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(loginBean.getPassword());

			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			boolean isValidUser = userService.signUp(loginBean.getUser_name(), hashedPassword, loginBean.getEmail(), dtf.format(LocalDateTime.now()));
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
