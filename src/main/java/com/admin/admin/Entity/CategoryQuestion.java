package com.admin.admin.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name=CategoryQuestion.TABLE_NAME)
public class CategoryQuestion {
    public static final String TABLE_NAME="category_question";
    @EmbeddedId
    CategoryQuestionComposite categoryQuestionComposite;

    public CategoryQuestion() {
    }

    public CategoryQuestion(CategoryQuestionComposite categoryQuestionComposite) {

        this.categoryQuestionComposite = categoryQuestionComposite;
    }

    public CategoryQuestionComposite getCategoryQuestionComposite() {
        return categoryQuestionComposite;
    }

    public void setCategoryQuestionComposite(CategoryQuestionComposite categoryQuestionComposite) {
        this.categoryQuestionComposite = categoryQuestionComposite;
    }
}
