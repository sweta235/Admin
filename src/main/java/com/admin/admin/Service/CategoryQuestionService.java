package com.admin.admin.Service;

import com.admin.admin.Entity.CategoryQuestion;
import com.admin.admin.Entity.CategoryQuestionComposite;
import com.admin.admin.Repository.CategoryQuestionCompositeRepository;

import java.util.List;

public interface CategoryQuestionService  {
    public List<CategoryQuestion> getAllByCategoryQuestionCompositeCategoryId(String categoryId);
}
