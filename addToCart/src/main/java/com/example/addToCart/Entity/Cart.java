package com.example.addToCart.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use appropriate generation strategy
	private long id;

	@Column(name = "userId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	private UUID userId;

	@Column(name = "productId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	private UUID productId;

	public Cart() {
		// No-arg constructor for JPA
	}

	public Cart(UUID userId, UUID productId) {
		this.userId = userId;
		this.productId = productId;
	}

	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				", userId=" + userId +
				", productId=" + productId +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cart)) return false;

		Cart cart = (Cart) o;

		return id == cart.id &&
				userId.equals(cart.userId) &&
				productId.equals(cart.productId);
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + userId.hashCode();
		result = 31 * result + productId.hashCode();
		return result;
	}
}
