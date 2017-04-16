package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/user")
	public String getUser(){
		return "user";
	}
	
	@RequestMapping(value="/user/{username}")
	public String getUserByName(@PathVariable String username, Model model){
		model.addAttribute("name",username);
		return "user";
	}
	
	@RequestMapping(value="/user/{username}/listusers")
	public String getUsers(@PathVariable String username, Model model){
		List<String> users= new ArrayList<String>();
		users.add("aaron");
		users.add("acute");
		users.add("andre");
		users.add("bob");
		users.add("emily");
		
		model.addAttribute("users",users);
		model.addAttribute("name",username);
		
		return "user";	}
	
	@RequestMapping(value="/user/paramuser")
	public String getUserById(@RequestParam Integer id, Model model){
		model.addAttribute("userid",id);
		return "user";
	}
	
	@RequestMapping(value="/user/message")
	@ResponseBody 
	public String sendMessage(){
		return "<h1>hello world!</h1>";
	}
	
	
}
