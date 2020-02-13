package com.ma.hookahMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private long productId;

	private String name;

	@NotNull
	private Double price;

}
