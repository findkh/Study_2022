package com.springboot.relationship.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
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
	@Disabled
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
	
	@Test
	@Disabled
	void relationshipTest() {
		//테스트 데이터 생성
		Provider provider = new Provider();
		provider.setName("수달물산");
		
		providerRepository.save(provider);
		
		Product product1 = new Product();
		product1.setName("모듈러");
		product1.setPrice(210000);
		product1.setStock(500);
		product1.setProvider(provider);
		
		Product product2 = new Product();
		product2.setName("시티");
		product2.setPrice(10000);
		product2.setStock(100);
		product2.setProvider(provider);
		
		Product product3 = new Product();
		product3.setName("해적선");
		product3.setPrice(300000);
		product3.setStock(50);
		product3.setProvider(provider);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		List<Product> products = providerRepository.findById(provider.getId()).get().getProductList();
		
		for(Product product : products) {
			System.out.println(product);
		}
	}
	
	@Test
	@Disabled
	void cascadeTest() {
		Provider provider = savedProvider("새로운 공급업체");
		
		Product product1 = savedProduct("상품1", 1000, 1000);
		Product product2 = savedProduct("상품2", 2000, 1000);
		Product product3 = savedProduct("상품3", 3000, 1000);
		
		//연관관계 설정
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		
		provider.getProductList().addAll(Lists.newArrayList(product1, product2, product3));
		
		providerRepository.save(provider);
	}
	
	private Provider savedProvider(String name) {
		Provider provider = new Provider();
		provider.setName(name);
		return provider;
	}
	
	private Product savedProduct(String name, Integer price, Integer stock) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		
		return product;
	}
	
	//고아 객체 제거 테스트
	@Test
	@Transactional
	void orphanRemovalTest() {
		Provider provider = savedProvider("새로운 공급업체");
		
		Product product1 = savedProduct("상품1", 1000, 1000);
		Product product2 = savedProduct("상품2", 2000, 1000);
		Product product3 = savedProduct("상품3", 3000, 1000);
		
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		
		provider.getProductList().addAll(Lists.newArrayList(product1, product2, product3));
		providerRepository.saveAndFlush(provider);
		
		providerRepository.findAll().forEach(System.out::println);
		productRepository.findAll().forEach(System.out::println);
		
		Provider foundProvider = providerRepository.findById(1L).get();
		foundProvider.getProductList().remove(0);
		
		providerRepository.findAll().forEach(System.out::println);
		productRepository.findAll().forEach(System.out::println);
	}
}
