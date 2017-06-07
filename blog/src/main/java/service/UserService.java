package service;

import java.util.List;

import entity.Request;
import entity.User;
import utility.ServiceStatus;

public interface UserService {
	ServiceStatus loginByEmail(String email, String password);
	
	ServiceStatus loginByName(String name, String password);
	
	ServiceStatus register(String name, String email, String password,
			String passwordConfirmed, String birthday, String gender,
			String country, String state, String city);
	
	ServiceStatus sendRequest(int senderId, int receiverId);
	
	ServiceStatus dealRequest(int requestId, int requestStatus);
	
	User userDisplay(String email);
	
	List<User> getStranger(String email);
	
	List<Request> getRequestBySenderId(String email);
	
	List<Request> getPendingRequestByReceiverId(String email);
	
	List<Request> getRequestByReceiverId(String email);
}
