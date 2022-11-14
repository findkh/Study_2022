package com.springboot.test.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.test.data.entity.Product;

@DataJpaTest
/* JPA�� ���õ� ������ �ε��ؼ� �׽�Ʈ ����
 *  @Transactional ������̼��� �����ϰ� �־� �׽�Ʈ �ڵ尡 ����Ǹ� �ڵ����� �����ͺ��̽��� �ѹ� �����
 *  �⺻������ �Ӻ���� DB ���
 */
public class ProductRepositoryTestByH2 {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Disabled
	//������ ���� �׽�Ʈ
	void saveTest() {
		//given
		Product product = new Product();
		product.setName("��");
		product.setPrice(1000);
		product.setStock(1000);
		
		//when
		Product savedProduct = productRepository.save(product);
		//System.out.println(savedProduct);
		
		//then
		assertEquals(product.getName(), savedProduct.getName());
		assertEquals(product.getPrice(), savedProduct.getPrice());
		assertEquals(product.getStock(), savedProduct.getStock());
	}
	
	@Test
	void selectTest() {
		//given
		Product product = new Product();
		product.setName("��");
		product.setPrice(1000);
		product.setStock(1000);
		
		Product savedProduct = productRepository.saveAndFlush(product);
		
		//when
		Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();
		
		//then
		assertEquals(product.getName(), savedProduct.getName());
		assertEquals(product.getPrice(), savedProduct.getPrice());
		assertEquals(product.getStock(), savedProduct.getStock());
	}
}
