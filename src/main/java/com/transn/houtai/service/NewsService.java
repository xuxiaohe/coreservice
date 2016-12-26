package com.transn.houtai.service;

import com.transn.houtai.domain.BannerManger;
import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.News;
import com.transn.houtai.repository.BannerMangerRepository;
import com.transn.houtai.repository.CategoryRepository;
import com.transn.houtai.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;



    public News saveBanner(News a){
        newsRepository.save(a);
        return a;
    }

    public Page<News> getallNewsByPage( Pageable pageable){
        Page<News> all = newsRepository.findAll(pageable);

        return  all;
    }


    public boolean deleteNews(News a){
        newsRepository.delete(a);
        return true;
    }

    public News getOneNews(int id){
        News one = newsRepository.findById(id);
        return one;
    }

    public boolean updateByTop(){
        newsRepository.updateByTop();


        return true;
    }



}
