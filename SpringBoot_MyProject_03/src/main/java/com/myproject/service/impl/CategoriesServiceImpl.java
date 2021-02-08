package com.myproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.Category;
import com.myproject.repository.CategoriesRepository;
import com.myproject.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	private CategoriesRepository categoriesRepository;

	public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {

		this.categoriesRepository = categoriesRepository;
	}

	@Override
	public void createCategoriesCollection() {
		
		categoriesRepository.createCategoriesCollection();
	}

	@Override
	public void dropCategoriesCollection() {
		
		categoriesRepository.dropCategoriesCollection();
	}

	@Override
	public void addCategory(String category) {
		
		categoriesRepository.addCategory(category);
	}

	@Override
	public void deleteCategory(String category) {
	
		categoriesRepository.deleteCategory(category);
	}

	@Override
	public List<Category> findAllCategories() {
	
		return categoriesRepository.findAllCategories();
	}

	@Override
	public void createCategory() {
		
		categoriesRepository.createCategory();
	}
}
