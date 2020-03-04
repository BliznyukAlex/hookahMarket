package com.ma.hookahMarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Товар.
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") //, insertable = false, updatable = false, nullable = false)
	private Long productId;

	@Column(name = "name")
	private String productName;

	@Column(name = "price")
	@NotNull
	private Double productPrice;

	@Column(name = "imagePath")
	private String productImagePath;

}
