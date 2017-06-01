package dao;

import java.util.List;

import entity.Request;

public interface RequestDao {
	public void insertNewRequest(Request request);
	
	public void updateRequestStatus(Request request);
	
	public List<Request> getRequestListByReceiverId(Integer receiverId);
	
	public List<Request> getPendingRequestListByReceiverId(Integer receiverId);
	
	public List<Request> getRequestListBySenderId(Integer senderId);
}
