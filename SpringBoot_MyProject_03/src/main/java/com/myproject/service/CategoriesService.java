package com.myproject.service;

import java.util.List;

import com.myproject.model.Category;

public interface CategoriesService {
	
	public void createCategoriesCollection();
	
	public void dropCategoriesCollection();
	
	public void createCategory();
	
	public void addCategory(String category);
	
	public void deleteCategory(String category);
	
	public List<Category> findAllCategories();

}
