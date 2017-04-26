package dao;

import java.util.Map;

import entity.Location;

public interface LocationDao {
	public Integer getLocationId(Location location);
	
	public void insertNewLocation(Location location);
}
