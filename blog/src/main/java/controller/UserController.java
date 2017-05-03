package controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
import service.UserService;
import service.UserServiceImpl;
import utility.ServiceStatus;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserDao userDao=new UserDaoImpl(); 
	private UserService userService=new UserServiceImpl();
	
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
		ServiceStatus status=userService.login(email, password);
		model.addAttribute("message", status.getStatusMessage());
		model.addAttribute("email",email);
		
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
			@RequestParam String passwordConfirmed, @RequestParam String birthday, @RequestParam String gender,@RequestParam String country, 
			@RequestParam String state, @RequestParam String city, Model model){
		ServiceStatus status=userService.register(name, email, password, passwordConfirmed, birthday, gender, country, state, city);
		/*if(password.equals(passwordConfirmed)){
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
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date birth=new Date(0);
			try {
				birth = (Date) sdf.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String g = null;
			if(gender.equals("Female")){
				g="F";
			}
			if(gender.equals("Male")){
				g="M";
			}
			userDao.insertNewUser(name, email, password, birth,g,id);
		
			return "login";
		}else{
			model.addAttribute("message", status.getStatusMessage());
			return "register";
		}*/
		int messageNum=status.getStatusCode();
		if(messageNum==0){
			return "login";
		}else{
			model.addAttribute("message", status.getStatusMessage());
			return "register";
		}
	}
	
}
