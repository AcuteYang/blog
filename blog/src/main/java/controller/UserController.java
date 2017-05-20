package controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.Request;
import entity.User;
import service.UserService;
import service.UserServiceImpl;
import utility.ServiceStatus;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/")
	public String displayLogin(){
		return "register";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/loginResult")
	public String validatePassword(@RequestParam String email, 
			@RequestParam String password,Model model){
		ServiceStatus status=userService.login(email, password);
		model.addAttribute("message", status.getStatusMessage());
		model.addAttribute("email",email);
		
		return "redirect:/user/display";
	}
	
	@RequestMapping(value="/display")
	public String userDisplay(@RequestParam String email, Model model){
		User user=userService.userDisplay(email);
		List<User> stranger=userService.getStranger(email);
		List<Request> request=userService.getRequestBySenderId(email);
		model.addAttribute("user",user);
		model.addAttribute("stranger", stranger);
		model.addAttribute("request",request);
		
		return "display";
	}
	
	@RequestMapping(value="/friend")
	public String friendDisplay(@RequestParam Model model){
		
		return "friend";
	}
	
	@RequestMapping(value="/register")
	public String passwordConfirmed(@RequestParam String name, 
			@RequestParam String email, @RequestParam String password,
			@RequestParam String passwordConfirmed, @RequestParam String birthday, 
			@RequestParam String gender,@RequestParam String country, 
			@RequestParam String state, @RequestParam String city, Model model){
		ServiceStatus status=userService.register(name, email, password, 
				passwordConfirmed, birthday, gender, country, state, city);
		int messageNum=status.getStatusCode();
		if(messageNum==0){
			return "login";
		}else{
			model.addAttribute("message", status.getStatusMessage());
			return "register";
		}
	}
	
}
