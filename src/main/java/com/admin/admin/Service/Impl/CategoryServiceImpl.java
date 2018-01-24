package com.admin.admin.Service.Impl;

import com.admin.admin.Dto.CategoryDto;
import com.admin.admin.Entity.Category;
import com.admin.admin.Repository.CategoryRepository;
import com.admin.admin.Service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public boolean save(CategoryDto categoryDto) {
        if(categoryRepository.exists(categoryDto.getCategoryId()))
            categoryRepository.delete(categoryDto.getCategoryId());
        Category category=new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        Category temp=new Category();
        temp= categoryRepository.save(category);
        if(temp==null)
            return false;
        else
        return true;
    }


    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findOne(String categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public List<CategoryDto> findEach(List<String> categoryId) {
        List <CategoryDto> categoryDtos=new ArrayList<CategoryDto>();
        for(String catId:categoryId)
        {
            Category category=new Category();
            category=categoryRepository.findOne(catId);
            CategoryDto categoryDto=new CategoryDto();

            BeanUtils.copyProperties(category,categoryDto);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }


}
