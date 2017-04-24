package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDao;
import dao.UserDaoImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserDao userDao=new UserDaoImpl(); 
	
	@RequestMapping(value="/")
	public String displayLogin(){
		return "register";
	}
	
	@RequestMapping(value="/login")
	public String validatePassword(@RequestParam String email, @RequestParam String password,Model model){
		String pwd=userDao.getPassword(email);
		if(pwd==null){
			model.addAttribute("message","email not found");
		}
		else if(pwd.equals(password)){
			model.addAttribute("message", "login successfully");
		}else{
			model.addAttribute("message", "login fail");
		}
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String passwordConfirmed(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String passwordConfirmed, @RequestParam Date birthday, Model model){
		if(password.equals(passwordConfirmed)){
			/*model.addAttribute("message", "register successful");*/
			userDao.insertNewUser(name, email, password, birthday);
			return "login";
		}else{
			model.addAttribute("message", "password confirmed dismatched");
			return "register";
		}
	}
	
}
