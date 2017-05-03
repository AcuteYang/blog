package service;

import utility.ServiceStatus;

public interface UserService {
	ServiceStatus login(String email, String password);
	
	ServiceStatus register(String name, String email, String password,
			String passwordConfirmed, String birthday, String gender,
			String country, String state, String city);
}
