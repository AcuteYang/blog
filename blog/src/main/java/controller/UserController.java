package controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		return "redirect:/user/friend";
	}
	
	@RequestMapping(value="/display")
	public String userDisplay(@RequestParam String email, Model model){
		
		
		return "display";
	}
	
	@RequestMapping(value="/friend")
	public String friendDisplay(@RequestParam Model model){
		
		return "friend";
	}
	@RequestMapping(value="/request")
	public String sendReqeust(){
		return "sendRequest";
	}
	
	@RequestMapping(value="/sendRequest")
	@ResponseBody
	public String sendReqeust(@RequestParam int senderId, 
			@RequestParam int receiverId){
		ServiceStatus status=userService.sendRequest(senderId, receiverId);
		
		return "success";
	}
	
	@RequestMapping(value="/dealRequest")
	public String dealRequest(@RequestParam int senderId,
			@RequestParam int receiverId, @RequestParam int requestStatus){
		ServiceStatus status=userService.dealRequest(senderId, receiverId, requestStatus);
		
		return "dealRequest";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
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
