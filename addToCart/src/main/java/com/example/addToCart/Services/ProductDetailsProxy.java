package com.example.addToCart.Services;

import com.example.addToCart.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class ProductDetailsProxy {

	private final RestTemplate restTemplate;

	@Autowired
	public ProductDetailsProxy(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Product getProductById(UUID productId) {
		String url = String.format("http://localhost:8082/amazon/products/search/%s", productId);
		return restTemplate.getForObject(url, Product.class);
	}
}
