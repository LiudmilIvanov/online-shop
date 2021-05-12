package com.example.demo.model.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

	@Column(unique = true)
	@Size(min = 3, max = 20)
	private String name;
	
	@Column(nullable = false)
	@DecimalMin(value = "0")
	private BigDecimal price;
	
	@Column(nullable = false)
	@Min(value = 0)
	private long quantity;
	
	@Column(columnDefinition = "TEXT")
	private String imageUrl;
	
	@ManyToOne
	private CategoryEntity category;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToMany(mappedBy = "products")
	List<OrderEntity> orders;
	
	public String getDescription() {
		return description;
	}

	public ProductEntity setDescription(String description) {
		this.description = description;
		return this;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public ProductEntity setCategory(CategoryEntity category) {
		this.category = category;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public ProductEntity setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public String getName() {
		return name;
	}

	public ProductEntity setName(String name) {
		this.name = name;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public ProductEntity setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public long getQuantity() {
		return quantity;
	}

	public ProductEntity setQuantity(long quantity) {
		this.quantity = quantity;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
