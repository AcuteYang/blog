package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import utility.MySqlSessionFactory;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory=MySqlSessionFactory.createFactory();
	public String getPassword(String email) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		String password=sqlSession.selectOne("mapper.userMapper.getPassword");
		MySqlSessionFactory factory = MySqlSessionFactory.createFactory();
		return password;
	}

}
