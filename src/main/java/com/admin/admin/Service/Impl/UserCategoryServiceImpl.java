package com.admin.admin.Service.Impl;

import com.admin.admin.Dto.UserCategoryDto;
import com.admin.admin.Entity.UserCategory;
import com.admin.admin.Repository.UserCategoryRepository;
import com.admin.admin.Service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class UserCategoryServiceImpl implements UserCategoryService {
    @Autowired
    UserCategoryRepository userCategoryRepository;
    @Override
    public boolean save(UserCategoryDto userCategoryDto) {
        UserCategory userCategory=new UserCategory();
        userCategory.setCategoryId(userCategoryDto.getCategoryId());
        userCategory.setUserId(userCategoryDto.getUserId());
        UserCategory temp=new UserCategory();
        temp=userCategoryRepository.save(userCategory);
        if(temp==null)
        return false;
        else
            return true;
    }

    @Override
    public List<UserCategory> findAll() {
        return (List<UserCategory>) userCategoryRepository.findAll();
    }

    @Override
    public UserCategory findOne(String categoryId) {
        return userCategoryRepository.findOne(categoryId);
    }
}
