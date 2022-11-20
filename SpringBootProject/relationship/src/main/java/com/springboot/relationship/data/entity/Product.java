package com.springboot.relationship.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "product")
public class Product extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stock;
	
	//일대일 양방향 매핑
	@OneToOne(mappedBy = "product") //mappedBy 속성 값은 연관관계를 갖고 있는 상대 엔티티에 있는 연관관계 필드 이름이 된다.
	@ToString.Exclude //양방향으로 연관관계가 설정되면 ToString을 사용할 때 순환참조가 발생한다. 순환참조 제거를 위해 Exclude 사용
	private ProductDetail productDetail;
	
	//다대일 단방향 매핑
	@ManyToOne
	@JoinColumn(name = "provider_id")
	@ToString.Exclude
	private Provider provider;
	
	//다대다 양방향 매핑
	@ManyToMany
	@ToString.Exclude
	private List<Producer> producers = new ArrayList<>();
	public void addProducer(Producer producer) {
		this.producers.add(producer);
	}
}
