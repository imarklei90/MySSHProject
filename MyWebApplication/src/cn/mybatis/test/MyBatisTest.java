package cn.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.mybatis.entity.User;

public class MyBatisTest {
	
	// 根据用户ID查询用户信息
	@Test
	public void testFindUserById() throws IOException{
		
		// 加载MyBatis的配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建会话工厂,传入MyBatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中Statement的ID，值为：namespace + "." + statement的ID
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		User user = sqlSession.selectOne("test.findUserById", 3);
		System.out.println(user);
		
		//	释放资源
		sqlSession.close();
	}
	 
	// 根据用户名模糊查询
	@Test
	public void testFindUserByName() throws IOException{
		SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
		List<User> lists = sqlSession.selectList("test.findUserByName", "xiao"); 
		System.out.println(lists);
		sqlSession.close();
	}
	
	// 添加用户信息
	@Test
	public void insertUser() throws IOException{
		SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
		User user = new User();
		user.setUsername("mybatis");
		user.setPassword("mybatis");
		sqlSession.insert("test.insertUser", user);
		
		// 提交事务
		sqlSession.commit();
		System.err.println(user.getId());
		
		sqlSession.close();
	}
	
	// 删除用户
	@Test
	public void deleteUser() throws IOException{
		SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
		sqlSession.delete("test.deleteUser", 3);
		
		// 提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	// 更新用户
	public void updateUser() throws IOException{
		SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
		
		User user = new User();
		user.setId(8);
		user.setUsername("ADMIN");
		user.setPassword("ADMIN123");
		
		sqlSession.update("test.updateUser", user);
		
		// 提交事务
		sqlSession.commit();
		
		sqlSession.close();
	}
}
