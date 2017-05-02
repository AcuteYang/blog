package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Blog;
import utility.MySqlSessionFactory;

public class BlogDaoImpl implements BlogDao {
	private SqlSessionFactory sqlSessionFactory=MySqlSessionFactory.createFactory();
	public List<Blog> getAllBlogs() {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		List<Blog> blogs=sqlSession.selectList("mapper.blogMapper.selectAllBlogs");
		return blogs;
	}

}
