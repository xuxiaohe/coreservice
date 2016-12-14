package com.transn.houtai.util.pages;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author 许瑞
 * @param <T> 传递的泛型对象
 */

public class Pager<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分页的起始页
	 */
	private int size=1;
	/**
	 * 每页显示条数 
	 */
	private int limit=50;
	/**
	 * 查询的总数
	 */
	private int total;
	
	private int totalpage;
	/**
	 * 分页的结果数据
	 */
	private List<T> datas;
	
	private int navPages=6; //导航页码数
	
	private int[] navPagerNumbers;  //所有导航页号
	
	public Pager(){}
	
	public Pager(int total,List<T> datas) {
		this.total = total;
		this.datas = datas;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int total,int limit) {
		this.totalpage = (total%limit==0)?(total/limit):(total/limit+1);
	}
	public void setTotalpage2(int total,int limit) {
		this.totalpage = (total%limit==0)?(total/limit+1):(total/limit+2);
	}
	
	public int[] getNavPagerNumbers() {
		return navPagerNumbers;
	}

	public void setNavPagerNumbers(int[] navPagerNumbers) {
		this.navPagerNumbers = navPagerNumbers;
	}

	/**
	 * 计算导航页
	 */
	public void calcNavPagerNumbers(){
		//当总页数小于或等于导航页码数时
		if(totalpage<=navPages){
			navPagerNumbers=new int[totalpage];
			for(int i=0;i<totalpage;i++){
				navPagerNumbers[i]=i+1;
			}
		}else{ //当总页数大于导航页码数时
			navPagerNumbers=new int[navPages];
			int startNum=size-navPages/2;
			int endNum=size+navPages/2;
			
			if(startNum<1){
				startNum=1;
				//(最前navPageCount页
				for(int i=0;i<navPages;i++){
					navPagerNumbers[i]=startNum++;
				}
			}else if(endNum>totalpage){
				endNum=totalpage;
				//最后navPageCount页
				for(int i=navPages-1;i>=0;i--){
					navPagerNumbers[i]=endNum--;
				}
			}else{
				//所有中间页
				for(int i=0;i<navPages;i++){
					navPagerNumbers[i]=startNum++;
				}
			}
		}
	}
}
