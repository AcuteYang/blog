package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Status;
import utility.MySqlSessionFactory;

public class StatusDaoImpl implements StatusDao {
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Status getStatus(int id) {
		Status status=sqlSession.selectOne("mapper.statusMapper.selectStatus", id);
		return status;
	}

	public void insertNewStatus(Status status) {
		// TODO Auto-generated method stub

	}

}
