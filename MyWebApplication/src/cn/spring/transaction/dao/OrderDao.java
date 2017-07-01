package cn.spring.transaction.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 收入
	public void incrSalary(){
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql, 1000, "aaa");
	}
	
	// 支出
	public void descSalary(){
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 1000,"bbb");
	}
}
