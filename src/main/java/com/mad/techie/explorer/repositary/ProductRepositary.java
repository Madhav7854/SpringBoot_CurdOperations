package com.mad.techie.explorer.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.techie.explorer.entity.Product;

public interface ProductRepositary extends JpaRepository<Product, Integer> {
	
	Product findByName(String name);

}
