package com.admin.admin.Dto;

import com.admin.admin.Entity.CategoryQuestionComposite;

public class CategoryQuestionCompositeDto {
    private CategoryQuestionComposite categoryQuestionComposite;

    public CategoryQuestionCompositeDto() {
    }

    public CategoryQuestionCompositeDto(CategoryQuestionComposite categoryQuestionComposite) {

        this.categoryQuestionComposite = categoryQuestionComposite;
    }

    public CategoryQuestionComposite getCategoryQuestionComposite() {

        return categoryQuestionComposite;
    }

    public void setCategoryQuestionComposite(CategoryQuestionComposite categoryQuestionComposite) {
        this.categoryQuestionComposite = categoryQuestionComposite;
    }
}
