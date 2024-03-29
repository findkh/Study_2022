package com.springboot.relationship.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "provider")
public class Provider extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	//공급업체 엔티티와 상품 엔티티의 일대다 연관관계 설정
	//@OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)

	//공급업체 엔티티에 영속성 전이 설정, 고아객체 정리
	@OneToMany(mappedBy = "provider", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@ToString.Exclude
	private List<Product> productList = new ArrayList<>();
}
