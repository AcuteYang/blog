package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Request;
import utility.MySqlSessionFactory;

public class RequestDaoImpl implements RequestDao {
	private SqlSession sqlSession;
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void insertNewRequest(Request request) {
		sqlSession.insert("mapper.requestMapper.insertNewRequest", request);
	}

	public void updateRequestStatus(Request request) {
		sqlSession.update("mapper.requestMapper.updateRequestStatus", request);
	}

	public List<Request> getRequestListByReceiverId(Integer receiverId) {
		List<Request> request=sqlSession.selectList("mapper.requestMapper.getRequestListByReceiverId", receiverId);
		return request;
	}

	public List<Request> getRequestListBySenderId(Integer senderId) {
		List<Request> request=sqlSession.selectList("mapper.requestMapper.getRequestListBySenderId", senderId);
		return request;
	}

	public List<Request> getPendingRequestListByReceiverId(Integer receiverId) {
		List<Request> request=sqlSession.selectList("mapper.requestMapper.getPendingRequestListByReceiverId", receiverId);
		return request;
	}

	public void insertNewRelationship(Request request) {
		Request temp=sqlSession.selectOne("mapper.requestMapper.getRequestByRequestId",request.getRequestId());
		sqlSession.insert("mapper.requestMapper.insertNewRelationship",temp);
		sqlSession.insert("mapper.requestMapper.insertNewRelationshipViceVersa",temp);
	}

	

}
