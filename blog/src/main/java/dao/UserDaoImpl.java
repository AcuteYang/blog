package dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	private SqlSession sqlSession;
	
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public String getPassword(String email) {
		String password=sqlSession.selectOne("mapper.userMapper.getPassword",email);
		return password;
	}
	
	public void insertNewUser(String name, String email, String password, Date birthday, String gender, Integer id){
		Map<String, Object> temp=new HashMap<String, Object>();
		temp.put("name", name);
		temp.put("email",email);
		temp.put("password",password);
		temp.put("birthday",birthday);
		temp.put("gender", gender);
		temp.put("locationId", id);
		sqlSession.insert("mapper.userMapper.insertNewUser",temp);
	}

	public User getUserByEmail(String email) {
		User user = sqlSession.selectOne("mapper.userMapper.selectUserByEmail",email);
		return user;
	}

	public List<User> getFriend(Integer userId) {
		List<User> friend=sqlSession.selectList("mapper.userMapper.selectFriend", userId);
		return friend;
	}

	public List<User> getStranger(Integer userId) {
		List<User> stranger=sqlSession.selectList("mapper.userMapper.selectStranger", userId);
		return stranger;
	}
}
