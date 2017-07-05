package cn.mybatis.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.entity.User;
import cn.mybatis.mapper.UserMapper;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException{
		String resource = "SqlMapConfig.xml";
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
	}
	
	@Test
	public void testFindUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成Mapper的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用UserMapper的方法
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
}
