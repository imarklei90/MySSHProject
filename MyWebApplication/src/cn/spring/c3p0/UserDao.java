package cn.spring.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	
	//得到JdbcTemplate对象
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(){
		System.out.println("userDao add.....");
		//测试
		String sql = "insert into user values(?,?)";
		jdbcTemplate.update(sql, "关磊","吴梦玲");
		
	}
	
}
