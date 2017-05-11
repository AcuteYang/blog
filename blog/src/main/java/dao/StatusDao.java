package dao;

import entity.Status;

public interface StatusDao {
	public Status getStatus(int id);
	
	public void insertNewStatus(Status status);
}
