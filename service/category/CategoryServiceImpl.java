package com.ekart.easy_connect.service.category;

import com.ekart.easy_connect.model.Category;

import java.util.List;

public interface CategoryServiceImpl {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category, Long id);
    void deleteCategoryById(Long id);

}
