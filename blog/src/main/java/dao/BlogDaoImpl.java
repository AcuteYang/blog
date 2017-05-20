package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.Blog;
import utility.MySqlSessionFactory;

public class BlogDaoImpl implements BlogDao {
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Blog> getAllBlogs() {
		List<Blog> blogs=sqlSession.selectList("mapper.blogMapper.selectAllBlogs");
		return blogs;
	}

}
