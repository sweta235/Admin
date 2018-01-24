package com.admin.admin.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=UserCategory.TABLE_NAME)
public class UserCategory {
    public static final String TABLE_NAME="user_category";
    @Id
    private String categoryId;
    private String userId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
