package com.springboot.advanced_jpa.data.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.advanced_jpa.data.repository.support.ProductRepository;

@SpringBootTest
public class AuditingTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void auditingTest() {
		Product product = new Product();
		product.setName("펜");
		product.setPrice(1500);
		product.setStock(10000);
		
		Product savedProduct = productRepository.save(product);
		
		System.out.println("productName : " + savedProduct.getName());
		System.out.println("createdAt : " + savedProduct.getCreateAt());
	}
	
}
