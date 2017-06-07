package dao;

import java.sql.Date;
import java.util.List;

import entity.User;

public interface UserDao {
	public String getPasswordByEmail(String email);
	public String getPasswordByName(String name);
	public User getUserByEmail(String email);
	public User getUserByName(String name);
	public User getUserById(Integer userId);
	public void insertNewUser(String name, String email, String password, 
							  Date birthday, String gender, Integer id);
	public List<User> getFriend(Integer userId);
	public List<User> getStranger(Integer userId);
}
