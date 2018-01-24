package com.admin.admin.Repository;

import com.admin.admin.Entity.CategoryQuestion;
import com.admin.admin.Entity.CategoryQuestionComposite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryQuestionCompositeRepository extends CrudRepository<CategoryQuestion,CategoryQuestionComposite> {
    public List<CategoryQuestion> findAllByCategoryQuestionCompositeCategoryId(String categoryId);
}
