package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Date birthday;
	private int birthplace;
	private Location currentLocation;
	private Timestamp createdTime;
	private List<User> friend;
	private Picture avatar;
	
	public List<User> getFriend() {
		return friend;
	}
	public void setFriend(List<User> friend) {
		this.friend = friend;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(int birthplace) {
		this.birthplace = birthplace;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public Picture getAvatar() {
		return avatar;
	}
	public void setAvatar(Picture avatar) {
		this.avatar = avatar;
	}
	
}
