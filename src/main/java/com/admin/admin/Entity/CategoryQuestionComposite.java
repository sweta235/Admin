package com.admin.admin.Entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class CategoryQuestionComposite implements Serializable {
    @NotNull
    private String categoryId;
    @NotNull
    private String questionId;

    public CategoryQuestionComposite() {
    }

    public CategoryQuestionComposite(String categoryId, String questionId) {

        this.categoryId = categoryId;
        this.questionId = questionId;
    }

    public String getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
