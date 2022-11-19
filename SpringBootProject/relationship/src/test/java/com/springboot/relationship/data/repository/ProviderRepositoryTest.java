package com.springboot.relationship.data.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.Provider;

@SpringBootTest
public class ProviderRepositoryTest {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Test
	void relationshipTest1() {
		Provider provider = new Provider();
		provider.setName("수달물산");
		
		providerRepository.save(provider);
		
		Product product = new Product();
		product.setName("레고");
		product.setPrice(5000);
		product.setStock(500);
		product.setProvider(provider);
		
		productRepository.save(product);
		System.out.println(product);
		
		//테스트
		System.out.println("Product : " + productRepository.findById(1L).orElseThrow(RuntimeException::new));
		
		System.out.println("provider: " + productRepository.findById(1L).orElseThrow(RuntimeException::new).getProvider());
	}
}
