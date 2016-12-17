package com.transn.houtai.repository;

import com.transn.houtai.domain.Categorys;
import com.transn.houtai.domain.News;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
@Repository
@Qualifier(value = "categoryRepository")
public interface CategoryRepository extends CrudRepository<Categorys, Long> {

    public Categorys findById(int id);
}
