package dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.User;
import utility.MySqlSessionFactory;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory=MySqlSessionFactory.createFactory();
	public String getPassword(String email) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		String password=sqlSession.selectOne("mapper.userMapper.getPassword",email);
		return password;
	}
	
	public void insertNewUser(String name, String email, String password, Date birthday, String gender, Integer id){
		SqlSession sqlSessionOne=sqlSessionFactory.openSession(true);
		Map<String, Object> temp=new HashMap<String, Object>();
		temp.put("name", name);
		temp.put("email",email);
		temp.put("password",password);
		temp.put("birthday",birthday);
		temp.put("gender", gender);
		temp.put("locationId", id);
		sqlSessionOne.insert("mapper.userMapper.insertNewUser",temp);
	}

	public User getUserByEmail(String email) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		User user = sqlSession.selectOne("mapper.userMapper.selectUserByEmail",email);
		return user;
	}

	public List<User> getFriend(Integer userId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<User> friend=sqlSession.selectList("mapper.userMapper.selectFriend", userId);
		return friend;
	}

	public List<User> getStranger(Integer userId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<User> stranger=sqlSession.selectList("mapper.userMapper.selectStranger", userId);
		return stranger;
	}
}
