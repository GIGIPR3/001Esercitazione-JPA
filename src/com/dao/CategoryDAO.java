package com.dao;

import java.util.List;

// Definisco un'interfaccia che si occupa dell'accesso ai dati relativi alle categorie utilizzando metodi crud

import com.entity.Category;

public interface CategoryDAO {

	public void insertCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(int categoryId);

	public List<Category> getAllCategories();
}
