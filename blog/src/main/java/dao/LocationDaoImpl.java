package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Location;
import utility.MySqlSessionFactory;

public class LocationDaoImpl implements LocationDao {
	private SqlSessionFactory sqlSessionFactory=MySqlSessionFactory.createFactory();
	public Integer getLocationId(Location location) {
		SqlSession sqlSessionOne=sqlSessionFactory.openSession(true);
		Integer locationId=sqlSessionOne.selectOne("mapper.locationMapper.selectLocationId",location);
		return locationId;
	}

	public void insertNewLocation(Location location) {
		SqlSession sqlSessionTwo=sqlSessionFactory.openSession(true);
		sqlSessionTwo.insert("mapper.locationMapper.insertNewLocation",location);
	}

}
