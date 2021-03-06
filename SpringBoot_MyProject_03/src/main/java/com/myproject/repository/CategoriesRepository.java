package com.myproject.repository;

import com.myproject.model.Category;

public interface CategoriesRepository {

	public void createCategoriesCollection();
	
	public void dropCategoriesCollection();
	
	public void createCategory();
	
	public void addCategory(String category);
	
	public void deleteCategory(String category);
	
	public Category findCategories();
}
