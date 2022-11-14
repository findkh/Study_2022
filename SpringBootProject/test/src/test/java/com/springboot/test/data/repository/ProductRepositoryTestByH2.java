package com.springboot.test.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.test.data.entity.Product;

@DataJpaTest
/* JPA와 관련된 설정만 로드해서 테스트 진행
 *  @Transactional 어노테이션을 포함하고 있어 테스트 코드가 종료되면 자동으로 데이터베이스의 롤백 진행됨
 *  기본값으로 임베디드 DB 사용
 */
public class ProductRepositoryTestByH2 {
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Disabled
	//데이터 저장 테스트
	void saveTest() {
		//given
		Product product = new Product();
		product.setName("펜");
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
		product.setName("펜");
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
