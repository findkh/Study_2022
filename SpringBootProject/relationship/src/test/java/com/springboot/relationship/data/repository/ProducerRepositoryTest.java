package com.springboot.relationship.data.repository;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.relationship.data.entity.Producer;
import com.springboot.relationship.data.entity.Product;

@SpringBootTest
public class ProducerRepositoryTest {
	@Autowired
	ProducerRepository producerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	@Transactional
	@Disabled
	void relationshipTest() {
		Product product1 = saveProduct("펜", 1000, 100);
		Product product2 = saveProduct("지우개", 2000, 100);
		Product product3 = saveProduct("공책", 3000, 100);
		
		Producer producer1 = saveProducer("수달공업");
		Producer producer2 = saveProducer("수달북스");
		
		producer1.addProduct(product1);
		producer1.addProduct(product2);
		
		producer2.addProduct(product3);
		producer2.addProduct(product2);
		
		producerRepository.saveAll(Lists.newArrayList(producer1, producer2));
		
		System.out.println(producerRepository.findById(1L).get().getProducts());
		
	}
	
	private Product saveProduct(String name, Integer price, Integer stock) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		return productRepository.save(product);
	}
	
	private Producer saveProducer(String name) {
		Producer producer = new Producer();
		producer.setName(name);
		
		return producerRepository.save(producer);
	}
	
	@Test
	@Transactional
	void relationshipTest2() {
		Product product1 = saveProduct("펜", 1000, 100);
		Product product2 = saveProduct("지우개", 2000, 100);
		Product product3 = saveProduct("공책", 3000, 100);
		
		Producer producer1 = saveProducer("수달공업");
		Producer producer2 = saveProducer("수달북스");
		
		producer1.addProduct(product1);
		producer1.addProduct(product2);
		producer2.addProduct(product2);
		producer2.addProduct(product3);
		
		product1.addProducer(producer1);
		product2.addProducer(producer1);
		product2.addProducer(producer2);
		product3.addProducer(producer2);
		
		producerRepository.saveAll(Lists.newArrayList(producer1, producer2));
		productRepository.saveAll(Lists.newArrayList(product1, product2, product3));
		
		System.out.println("products: " + producerRepository.findById(1L).get().getProducts());
		System.out.println("producers: " + productRepository.findById(2L).get().getProducers());
	}
}
