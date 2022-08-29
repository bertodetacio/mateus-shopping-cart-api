package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.ProductNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Product;
import br.com.mateus.shoppingcart.domain.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductService {
		
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public Product findProductByIdOrFail(Long productId) {
		return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
	}
	

}
