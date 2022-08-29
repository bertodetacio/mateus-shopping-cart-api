package br.com.mateus.shoppingcart.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateus.shoppingcart.domain.exceptions.CategoryNotFoundException;
import br.com.mateus.shoppingcart.domain.model.Category;
import br.com.mateus.shoppingcart.domain.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CategoryService {
		
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAllsCategorys(){
		return categoryRepository.findAll();
	}
	
	public Category findCategoryByIdOrFail(Long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
	}
	

}
