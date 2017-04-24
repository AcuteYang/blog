package dao;

import java.sql.Date;

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
	
	public void insertNewUser(String name, String email, String password, Date birthday){
		SqlSession sqlSessionOne=sqlSessionFactory.openSession(true);
		User temp=new User();
		temp.setBirthday(birthday);
		temp.setEmail(email);
		temp.setPassword(password);
		temp.setName(name);
		sqlSessionOne.insert("mapper.userMapper.insertNewUser",temp);
	}
}
