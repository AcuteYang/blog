package service;

import java.util.List;

import entity.Request;
import entity.User;
import utility.ServiceStatus;

public interface UserService {
	ServiceStatus login(String email, String password);
	
	
	ServiceStatus register(String name, String email, String password,
			String passwordConfirmed, String birthday, String gender,
			String country, String state, String city);
	
	ServiceStatus sendRequst(int senderId, int receiverId);
	
	ServiceStatus dealRequest(Request request);
	
	User userDisplay(String email);
	
	List<User> getStranger(String email);
	
	List<Request> getRequestBySenderId(String email);
}
