package com.example.demo.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.demo.entities.Book;

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
		
//		String sql = "INSERT INTO books(title, author, price) VALUES(?,?,?)";
//		int result = jdbcTemplate.update(sql, "Counter Hack Reloaded", "Skoudis", 17.96f);
//		if (result >0) {
//			System.out.println(result + " books are inserted");
//		}
		
		String sql = "SELECT * FROM books";
		RowMapper<Book> rowMapper = new RowMapper<Book>() {
			public Book mapRow(ResultSet result, int row) throws SQLException {
				Integer id = result.getInt("book_id");
				String title = result.getString("title");
				String author = result.getString("author");
				float price = result.getFloat("price");
				
				return new Book(id, title, author, price);
			}
		};
		List<Book> books = jdbcTemplate.query(sql, rowMapper);
		for (Book book : books) {
			System.out.println(book);
		}
		
		sql = "SELECT * FROM books WHERE book_id <4";
		books = jdbcTemplate.query(sql, rowMapper);
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
