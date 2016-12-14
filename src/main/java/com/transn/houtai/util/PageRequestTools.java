package com.transn.houtai.util;

import com.transn.houtai.util.pages.QueryModelMul;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装分页标签
 * @param
 * @return
 */
public class PageRequestTools {



public static PageRequest pageRequesMake(QueryModelMul dm)

{	
	//排序字段
	List<String> sortList = dm.getSort();
	if (sortList==null){
		//tang 添加一行
		sortList=new ArrayList<String>();
		sortList.add("ctime");
		dm.setSort(sortList);
	}
	//排序方式 默认DESC
	Direction d = Direction.DESC;
	if(dm.getMode().equalsIgnoreCase("ASC")){
		d = Direction.ASC;
	}
	Sort st = new Sort(d,dm.getSort());
	
   return new PageRequest(dm.getN(),dm.getS(),st);
}

}
