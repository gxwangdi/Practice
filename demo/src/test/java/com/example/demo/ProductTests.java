package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class ProductTests {

	@Autowired
	private ProductRepository repo;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateProduct() {
		Product product = new Product("iPhone 10", 789);
		Product savedProduct = repo.save(product);
		
		assertNotNull(savedProduct);
	}
	
	@Test
	@Order(2)
	public void testFindProductByName() {
		String name = "iPhone 10";
		Product product = repo.findByName(name);
		
		assertThat(product.getName()).isEqualTo(name);
	}
	
	@Test
	@Order(3)
	public void testFindProductByNameNotExists() {
		String name = "iPhone 11";
		Product product = repo.findByName(name);
		
		assertNull(product);
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateProduct() {
		String productName = "Kindle Reader";
		Product product = new Product(productName, 199);
		product.setId(2);
		
		repo.save(product);
		Product updatedProduct = repo.findByName(productName);
		
		assertThat(updatedProduct.getName()).isEqualTo(productName);
	}
	
	@Test
	@Order(5)
	public void testListProducts() {
		List<Product> products = (List<Product>) repo.findAll();
		for (Product product : products) {
			System.out.println(product);
		}
		
		assertThat(products).size().isGreaterThan(0);
	}
	
	@Test
	@Order(6)
	public void testDeleteProduct() {
		Integer id = 1;
		boolean presentBefore = repo.findById(id).isPresent();
		repo.deleteById(id);
		
		boolean presentAfter = repo.findById(id).isPresent();
		
		assertTrue(presentBefore);
		assertFalse(presentAfter);
	}
}
