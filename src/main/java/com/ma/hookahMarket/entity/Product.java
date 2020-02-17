package com.ma.hookahMarket.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Товар.
 */
//@NoArgsConstructor
@Data
//@Getter
//@Setter
//@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") //, insertable = false, updatable = false, nullable = false)
	private Long productId;

	@Column(name = "name", nullable = false)
	private String productName;

	@Column(name = "price", nullable = false)
	@NotNull
	private Double productPrice;

	public Product() {
	}
	public Product(Long productId,String productName,Double productPrice) {
		this.productId=productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
}
