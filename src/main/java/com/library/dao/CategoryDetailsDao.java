package com.library.dao;
import com.library.entity.CategoryDetails;
import java.util.List;
public interface CategoryDetailsDao 
{
	  void addCategory(CategoryDetails categoryDetails);
      void updateCategory(CategoryDetails categoryDetails);
      void deleteCategory(int categoryId);
      CategoryDetails getCategoryById(int categoryId);
      List<CategoryDetails> getAllCategories();
}
