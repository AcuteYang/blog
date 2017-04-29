package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.LocationDao;
import dao.LocationDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.Location;
import entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserDao userDao=new UserDaoImpl(); 
	private LocationDao locationDao=new LocationDaoImpl();
	
	@RequestMapping(value="/")
	public String displayLogin(){
		return "register";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/loginResult")
	public String validatePassword(@RequestParam String email, @RequestParam String password,Model model){
		String pwd=userDao.getPassword(email);
		if(pwd==null){
			model.addAttribute("message","email not found");
		}
		else if(pwd.equals(password)){
			model.addAttribute("message", "login successfully");
			model.addAttribute("email",email);
		}else{
			model.addAttribute("message", "login fail");
		}
		return "redirect:/user/display";
	}
	
	@RequestMapping(value="/display")
	public String userDisplay(@RequestParam String email, Model model){
		User user=userDao.getUserByEmail(email);
		List<User> friend=userDao.getFriend(user.getUserId());
		user.setFriend(friend);
		model.addAttribute("user",user);
		
		return "display";
	}
	
	@RequestMapping(value="/register")
	public String passwordConfirmed(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String passwordConfirmed, @RequestParam Date birthday, @RequestParam String gender,@RequestParam String country, 
			@RequestParam String state, @RequestParam String city, Model model){
		if(password.equals(passwordConfirmed)){
			/*model.addAttribute("message", "register successful");*/
			Location temp=new Location();
			temp.setCountry(country);
			temp.setState(state);
			temp.setCity(city);
			Integer locationId=locationDao.getLocationId(temp);
			if(locationId==null){
				locationDao.insertNewLocation(temp);
			}
			Integer id=locationDao.getLocationId(temp);
			temp.setLocationId(id);
			userDao.insertNewUser(name, email, password, birthday,gender,id);
			return "login";
		}else{
			model.addAttribute("message", "password confirmed dismatched");
			return "register";
		}
	}
	
}
