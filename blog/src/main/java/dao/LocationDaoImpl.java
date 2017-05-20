package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Location;
import utility.MySqlSessionFactory;

public class LocationDaoImpl implements LocationDao {
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Integer getLocationId(Location location) {
		Integer locationId=sqlSession.selectOne("mapper.locationMapper.selectLocationId",location);
		return locationId;
	}

	public void insertNewLocation(Location location) {
		sqlSession.insert("mapper.locationMapper.insertNewLocation",location);
	}

}
