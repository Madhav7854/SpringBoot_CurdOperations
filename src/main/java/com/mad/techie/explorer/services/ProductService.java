package com.mad.techie.explorer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mad.techie.explorer.entity.Product;
import com.mad.techie.explorer.repositary.ProductRepositary;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepositary productRepositary;

	public Product saveProduct(Product product) {
		return productRepositary.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepositary.saveAll(products);
	}

	public List<Product> getProducts() {
		return productRepositary.findAll();
	}

	public Product getProductById(int id) {
		return productRepositary.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return productRepositary.findByName(name);
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productRepositary.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepositary.save(existingProduct);
	}

	public String DeleteProduct(int id) {
		productRepositary.deleteById(id);
		return "Product Id is Removed From DB " + id;

	}
}
