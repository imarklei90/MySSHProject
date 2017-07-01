package cn.spring.test;
/**
 * 使用Spring的JdbcTemplate实现CRUD操作
 * @author iustc
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import sun.launcher.resources.launcher;


public class JdbcTemplateTest {

	// 添加
	@Test
	public void testAdd(){
		// 设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		// 创建JdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// 调用JdbcTemplate对象里的方法实现操作
		String sql = "insert into user values(?,?)";
		jdbcTemplate.update(sql, "aaa","123");
	}
	
	// 修改
	@Test
	public void testUpdate(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update user set username=? where username=?";
		jdbcTemplate.update(sql, "admin","Admin");
	}
	
	// 删除
	@Test
	public void testDelete(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from user where username=?";
		jdbcTemplate.update(sql, "aaa");
	}
	
	// 查询返回某一个值
	@Test
	public void testQuery1(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(*) from user";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("count:" + count);
	}
	
	//查询返回一个对象
	@Test
	public void testQuery2(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from user where username=?";
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "tom");
		System.out.println(user);
		
	}
	
	//查询返回一个List集合
	@Test
	public void testQuery3(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from user";
		List<User> user = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(user);
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	}
}

class User{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}


// 定义RowMapper的实现类
class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		// 从结果集中获取数据
		String username = rs.getString("username");
		String password = rs.getString("password");
		// 将数据封装到对象中
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		return user;
	}
	
}