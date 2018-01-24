package com.admin.admin.Controller;

import com.admin.admin.Dto.CategoryDto;
import com.admin.admin.Dto.CategoryQuestionCompositeDto;
import com.admin.admin.Dto.UserCategoryDto;
import com.admin.admin.Entity.Category;
import com.admin.admin.Entity.CategoryQuestion;
import com.admin.admin.Entity.CategoryQuestionComposite;
import com.admin.admin.Entity.UserCategory;
import com.admin.admin.Service.CategoryQuestionService;
import com.admin.admin.Service.CategoryService;
import com.admin.admin.Service.UserCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController

public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserCategoryService userCategoryService;

    @RequestMapping(method = RequestMethod.POST,value = "/saveCategory",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean>save(@RequestBody CategoryDto categoryDto)
    {
        Boolean status=categoryService.save(categoryDto);
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.List<CategoryDto>> getAllCategories() {
        java.util.List<Category> categoryList = categoryService.findAll();
        java.util.List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category, categoryDto);
            categoryDtos.add(categoryDto);
        }
        return new ResponseEntity<List<CategoryDto>>(categoryDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCategoryDetails/{categoryId}")
    public ResponseEntity<?> getCategoryDetails(@PathVariable("categoryId") String categoryId){
        Category category = categoryService.findOne(categoryId);
        CategoryDto categoryDto = new CategoryDto();
        if(category == null){
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
        BeanUtils.copyProperties(category,categoryDto);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

@RequestMapping(method = RequestMethod.POST,value = "/getCategoryList" )
public ResponseEntity<?>getCategoryList(@RequestBody List<String> categoryId)
{
    List<CategoryDto>categoryDtos=new ArrayList<>();
    categoryDtos=categoryService.findEach((List<String>) categoryId);
    return new ResponseEntity<List<CategoryDto>>(categoryDtos,HttpStatus.OK);
}


    @RequestMapping(method = RequestMethod.POST,value = "/saveModerator",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean>saveModerator(@RequestBody UserCategoryDto userCategoryDto)
    {
        Boolean status=userCategoryService.save(userCategoryDto);
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAllModerators", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.List<UserCategoryDto>> getAllModerators() {
        java.util.List<UserCategory> userCategoryList = userCategoryService.findAll();
        java.util.List<UserCategoryDto> userCategoryDtos = new ArrayList<>();
        for (UserCategory userCategory : userCategoryList) {
            UserCategoryDto userCategoryDto = new UserCategoryDto();
            BeanUtils.copyProperties(userCategory, userCategoryDto);
            userCategoryDtos.add(userCategoryDto);
        }
        return new ResponseEntity<List<UserCategoryDto>>(userCategoryDtos, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getOne/{categoryId}")
    public ResponseEntity<?> getOne(@PathVariable("categoryId") String categoryId){
        UserCategory userCategory = userCategoryService.findOne(categoryId);
        UserCategoryDto userCategoryDto = new UserCategoryDto();
        if(userCategory == null){
            return new ResponseEntity<String>("", HttpStatus.OK);
        }
        BeanUtils.copyProperties(userCategory,userCategoryDto);
        return new ResponseEntity<UserCategoryDto>(userCategoryDto, HttpStatus.OK);
    }

    @Autowired
    private CategoryQuestionService categoryQuestionService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/getAllByCategoryQuestionCompositeCategoryId/{categoryId}")
    public ResponseEntity<?> getAllByCategoryQuestionCompositeCategoryId(@PathVariable("categoryId") String categoryId) {
        List<CategoryQuestion> categoryQuestions = categoryQuestionService.getAllByCategoryQuestionCompositeCategoryId(categoryId);
        List<CategoryQuestionCompositeDto> categoryQuestionCompositeDtos = new ArrayList<>();
        for (CategoryQuestion categoryQuestion : categoryQuestions) {
            CategoryQuestionCompositeDto categoryQuestionCompositeDto = new CategoryQuestionCompositeDto();
            if (categoryQuestion == null) {
                return new ResponseEntity<String>("", HttpStatus.OK);
            }
            BeanUtils.copyProperties(categoryQuestion, categoryQuestionCompositeDto);
            categoryQuestionCompositeDtos.add(categoryQuestionCompositeDto);
        }

        return new ResponseEntity<List<CategoryQuestionCompositeDto>>(categoryQuestionCompositeDtos, HttpStatus.OK);

    }
}
