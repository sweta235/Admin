package com.admin.admin.Service.Impl;

import com.admin.admin.Entity.CategoryQuestion;
import com.admin.admin.Entity.CategoryQuestionComposite;
import com.admin.admin.Repository.CategoryQuestionCompositeRepository;
import com.admin.admin.Service.CategoryQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class CategoryQuestionServiceImpl implements CategoryQuestionService {

    @Autowired
    CategoryQuestionCompositeRepository categoryQuestionCompositeRepository;
    @Override
    public List<CategoryQuestion> getAllByCategoryQuestionCompositeCategoryId(String categoryId) {
        return categoryQuestionCompositeRepository.findAllByCategoryQuestionCompositeCategoryId(categoryId);
    }
}
