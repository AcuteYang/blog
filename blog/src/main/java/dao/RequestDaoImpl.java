package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Request;
import utility.MySqlSessionFactory;

public class RequestDaoImpl implements RequestDao {
	private SqlSessionFactory sqlSessionFactory=MySqlSessionFactory.createFactory();
	public void insertNewRequest(Request request) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		sqlSession.insert("mapper.requestMapper.insertNewRequest", request);
	}

	public void updateRequestStatus(Request request) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		sqlSession.update("mapper.requestMapper.updateRequestStatus", request);
	}

	public List<Request> getRequestListBySenderId(Integer senderId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Request> request=sqlSession.selectList("mapper.requestMapper.getRequestListBySenderId", senderId);
		return request;
	}

	

}
