package com.springboot.relationship.data.repository.support;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.QProduct;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom{

	public ProductRepositoryCustomImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> findByName(String name) {
		QProduct product = QProduct.product;
		
		List<Product> productList = from(product)
				.where(product.name.eq(name))
				.select(product)
				.fetch();
		return productList;
	}
	
	

}
