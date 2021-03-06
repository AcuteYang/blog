package service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.LocationDao;
import dao.LocationDaoImpl;
import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.StatusDao;
import dao.UserDao;
import entity.Location;
import entity.Request;
import entity.Status;
import entity.User;
import utility.ServiceStatus;
import utility.StatusCode;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private LocationDao locationDao;
	private RequestDao requestDao;
	private StatusDao statusDao;
	
	public StatusDao getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public RequestDao getRequestDao() {
		return requestDao;
	}

	public void setRequestDao(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

	public ServiceStatus loginByEmail(String email, String password) {
		String pwd=userDao.getPasswordByEmail(email);
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
	public ServiceStatus register(String name, String email, String password, 
			String passwordConfirmed, String birthday,	String gender, 
			String country, String state, String city) {
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
	
	public ServiceStatus dealRequest(int requestId, int requestStatus) {
		Request request=new Request();
		request.setRequestId(requestId);
		Status status=statusDao.getStatus(requestStatus);
		request.setRequestStatus(status);
		requestDao.updateRequestStatus(request);
		ServiceStatus serviceStatus=new ServiceStatus();
		if(requestStatus==StatusCode.ACCEPTED.toValue()){
			serviceStatus.setStatusCode(0);
			serviceStatus.setStatusMessage("request accepted");
			requestDao.insertNewRelationship(request);
		}else{
			serviceStatus.setStatusCode(-1);
			serviceStatus.setStatusMessage("request declined");
		}
		return serviceStatus;
	}
	
	public User userDisplay(String email) {
		User user=userDao.getUserByEmail(email);
		List<User> friend=userDao.getFriend(user.getUserId());
		user.setFriend(friend);
		return user;
	}

	public List<User> getStranger(String email) {
		User user=userDao.getUserByEmail(email);
		List<User> stranger=userDao.getStranger(user.getUserId());
		return stranger;
	}
	
	public List<Request> getRequestBySenderId(String email) {
		User user=userDao.getUserByEmail(email);
		List<Request> request=requestDao.getRequestListBySenderId(user.getUserId());
		return request;
	}

	public ServiceStatus sendRequest(int senderId, int receiverId) {
		Request request=new Request();
		User receiver=userDao.getUserById(receiverId);
		request.setReceiver(receiver);
		User sender=userDao.getUserById(senderId);
		request.setSender(sender);
		Status status=statusDao.getStatus(StatusCode.PENDING.toValue());
		request.setRequestStatus(status);
		requestDao.insertNewRequest(request);
		ServiceStatus serviceStatus=new ServiceStatus(); 
		serviceStatus.setStatusCode(0);
		serviceStatus.setStatusMessage("request sent successfully");
		return serviceStatus;
	}

	public List<Request> getPendingRequestByReceiverId(String email) {
		User user=userDao.getUserByEmail(email);
		List<Request> request=requestDao.getPendingRequestListByReceiverId(user.getUserId());
		return request;
	}

	public List<Request> getRequestByReceiverId(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceStatus loginByName(String name, String password) {
		String pwd=userDao.getPasswordByName(name);
		ServiceStatus serviceStatus=new ServiceStatus();
		if(pwd==null){
			serviceStatus.setStatusCode(1);
			serviceStatus.setStatusMessage("username not found");
		}
		else if(pwd.equals(password)){
			serviceStatus.setStatusCode(0);
			serviceStatus.setStatusMessage("login successfully");
		}else{
			serviceStatus.setStatusCode(2);
			serviceStatus.setStatusMessage("password wrong");
		}
		return serviceStatus;
	}

}
