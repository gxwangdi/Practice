package com.example.demo.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * A Simple Java application for JdbcTemplate demo. 
 * 
 * */
public class SpringJdbcTemplateDemo {
	
	public static void main(String[] args) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/salesdb?serverTimezone=UTC");
		dataSource.setUsername("demo");
		dataSource.setPassword("password");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "INSERT INTO books(title, author, price) VALUES(?,?,?)";
		int result = jdbcTemplate.update(sql, "Counter Hack Reloaded", "Skoudis", 17.96f);
		if (result >0) {
			System.out.println(result + " books are inserted");
		}
	}

}
