package com.sportyshoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entries.Products;
import com.sportyshoes.repository.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductRepository productRepository;
	
    public Products SaveProduct(Products products) {
    	
    	return productRepository.save(products);
    }
	public Iterable<Products> GetAllProducts()
	{
	   return productRepository.findAll();
	}

	public Products GetProductsById(int id)
    {
    	//TODO: Handle non-existent user. Currently throws an exception
    	
    	Optional<Products> product = productRepository.findById(id);
    	
    	return product.get();
    }

    public Products EditProduct(Products products) {
    	
    	//TODO: Not doing any error checking
    	
    	return productRepository.save(products);
    }
	
	
	
}
