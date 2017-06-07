package controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
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
	@ResponseBody
	public ServiceStatus validatePasswordByEmail(@RequestParam String unique, 
			@RequestParam String password, @RequestParam String type){
		ServiceStatus status=new ServiceStatus();
		if(type.equals("email")){
			String email=unique;
			status=userService.loginByEmail(email, password);
		}else{
			String name=unique;
			status=userService.loginByName(name, password);
		}
		return status;
	}
	
	@RequestMapping(value="/display")
	public String userDisplay(@RequestParam String email, Model model){
		return "display";
	}
	
	@RequestMapping(value="/getStranger")
	@ResponseBody
	public List<User> getStranger() {
		return userService.getStranger("sanchez38@sina.com");
	}
	
	@RequestMapping(value="/getPendingRequest")
	@ResponseBody
	public List<Request> getPendingRequest(){
		return userService.getPendingRequestByReceiverId("bourikas98@163.com");
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
	public ServiceStatus sendReqeust(@RequestParam int senderId, 
			@RequestParam int receiverId){
		ServiceStatus status=userService.sendRequest(senderId, receiverId);
		return status;
	}
	
	@RequestMapping(value="/dealRequest")
	@ResponseBody
	public ServiceStatus dealRequest(
			@RequestParam int requestId, @RequestParam int requestStatus){
		ServiceStatus status=userService.dealRequest(requestId, requestStatus);
		
		return status;
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
