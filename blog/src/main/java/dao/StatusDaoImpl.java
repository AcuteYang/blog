package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Status;
import utility.MySqlSessionFactory;

public class StatusDaoImpl implements StatusDao {
	private SqlSessionFactory sqlSessionFactory=MySqlSessionFactory.createFactory();
	
	public Status getStatus(int id) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		Status status=sqlSession.selectOne("mapper.statusMapper.selectStatus", id);
		return status;
	}

	public void insertNewStatus(Status status) {
		// TODO Auto-generated method stub

	}

}
