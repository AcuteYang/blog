package dao;

import java.sql.Date;

import entity.User;

public interface UserDao {
	public String getPassword(String email);
	public User getUserByEmail(String email);
	public void insertNewUser(String name, String email, String password, Date birthday, String gender, Integer id);
}
