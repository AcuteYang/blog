package service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.LocationDao;
import dao.LocationDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.Location;
import utility.ServiceStatus;

public class UserServiceImpl implements UserService {
	private UserDao userDao=new UserDaoImpl();
	private LocationDao locationDao=new LocationDaoImpl();
	public ServiceStatus login(String email, String password) {
		String pwd=userDao.getPassword(email);
		ServiceStatus serviceStatus=new ServiceStatus();
		if(pwd==null){
			serviceStatus.setStatusCode(1);
			serviceStatus.setStatusMessage("email not found");
		}
		else if(pwd.equals(password)){
			serviceStatus.setStatusCode(0);
			serviceStatus.setStatusMessage("login successfully");
		}else{
			serviceStatus.setStatusCode(2);
			serviceStatus.setStatusMessage("password incorrect");
		}
		return serviceStatus;
	}
	public ServiceStatus register(String name, String email, String password, String passwordConfirmed, String birthday,
			String gender, String country, String state, String city) {
		ServiceStatus serviceStatus=new ServiceStatus();
		if(password.equals(passwordConfirmed)){
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
				birth = new Date(sdf.parse(birthday).getTime());
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
			serviceStatus.setStatusCode(0);
			serviceStatus.setStatusMessage("register successfully");
		}else{
			serviceStatus.setStatusCode(3);
			serviceStatus.setStatusMessage("password confirmed dismatched");
		}
		return serviceStatus;
	}

}
