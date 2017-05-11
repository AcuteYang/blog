package entity;

import dao.StatusDao;
import dao.StatusDaoImpl;

public class Request {
	private int requestId;
	private User sender;
	private User receiver;
	private Status requestStatus;
	
	private StatusDao statusDao = new StatusDaoImpl();
	
	public Request(){
		requestStatus=statusDao.getStatus(1);
	}
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public Status getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(Status requestStatus) {
		this.requestStatus = requestStatus;
	}
}
