package com.example.demo.model.binding;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.example.demo.model.enums.CategoryTypeEnum;

public class ProductAddBindingModel {

	private String name;
	
	private String imageUrl;
	
	private CategoryTypeEnum category;
	
	private BigDecimal price;
	
	private long quantity;
	
	private String description;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CategoryTypeEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryTypeEnum category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
