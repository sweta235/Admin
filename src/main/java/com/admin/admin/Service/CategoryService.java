package com.admin.admin.Service;

import com.admin.admin.Dto.CategoryDto;
import com.admin.admin.Entity.Category;

import java.util.List;

public interface CategoryService {
    public boolean save(CategoryDto categoryDto);
    public List<Category>findAll();
    public Category findOne(String categoryId);
    public List<CategoryDto> findEach(List<String> categoryId);
}
