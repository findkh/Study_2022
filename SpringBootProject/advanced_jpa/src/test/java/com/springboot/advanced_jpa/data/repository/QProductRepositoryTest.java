package com.springboot.advanced_jpa.data.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.core.types.Predicate;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.entity.QProduct;

@SpringBootTest
public class QProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	QProductRepository qProductRepository;
	
	//Predicate를 활용한 findOne() 메서드 호출
	@Test
	public void queryDSLTest1() {
		Product product1 = new Product();
		product1.setName("펜");
		product1.setPrice(1000);
		product1.setStock(100);
//		product1.setCreatedAt(LocalDateTime.now());
//		product1.setUpdateAt(LocalDateTime.now());
		
		Product product2 = new Product();
		product2.setName("펜");
		product2.setPrice(3000);
		product2.setStock(300);
//		product2.setCreatedAt(LocalDateTime.now());
//		product2.setUpdateAt(LocalDateTime.now());
		
		Product product3 = new Product();
		product3.setName("펜");
		product3.setPrice(500);
		product3.setStock(50);
//		product3.setCreatedAt(null);
//		product3.setCreatedAt(LocalDateTime.now());
//		product3.setUpdateAt(LocalDateTime.now());
//		
		Product savedProduct1 = productRepository.save(product1);
		Product savedProduct2 = productRepository.save(product2);
		Product savedProduct3 = productRepository.save(product3);
		
		Predicate predicate = QProduct.product.name.containsIgnoreCase("펜")
				.and(QProduct.product.price.between(1000, 2500));
		
		Optional<Product> foundProduct = qProductRepository.findOne(predicate);
		
		if(foundProduct.isPresent()) {
			Product product = foundProduct.get();
			System.out.println(product.getNumber());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getStock());
		}
	}
	
	@Test
	public void queryDSLTest2() {
		QProduct qProduct = QProduct.product;
		Iterable<Product> productList = qProductRepository.findAll(
				qProduct.name.contains("펜")
				.and(qProduct.price.between(550, 1500))
				);
		
		for(Product product : productList) {
			System.out.println("===========queryDSLTest2=========");
			System.out.println(product.getNumber());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getStock());
		}
	}
}
