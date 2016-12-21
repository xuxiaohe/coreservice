package com.transn.houtai.service;

import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.News;
import com.transn.houtai.repository.CategoryRepository;
import com.transn.houtai.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewsRepository newsRepository;

    public boolean deleteCategory(Categorys c){

        newsRepository.updateByCategoryid(c.getId());
        categoryRepository.delete(c);

        return true;
    }


    public Categorys getCategory(int id){
        Categorys byId = categoryRepository.findById(id);
        return byId;
    }


    public List<Categorys> getAllCategory(){
        Sort s=new Sort(Sort.Direction.ASC, "id");
        List one = (List) categoryRepository.findAll(s);
        return one;
    }

    public Categorys saveCategory(Categorys s){
        Categorys save = categoryRepository.save(s);
        return save;
    }

    public boolean updateCategoryByid(String name,int id){
        categoryRepository.updateCategoryById(name,id);
        return true;
    }



}
