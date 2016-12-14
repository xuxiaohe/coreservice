package com.transn.houtai.controller;

import com.transn.houtai.util.ReponseData;
import com.transn.houtai.util.ResponseContainer;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class BaseController {

	private static final Logger logger = Logger.getLogger(BaseController.class);


	public static Map<String, List<Map<String, String>>> directionaryMap=null;

	/**
	 * ResponseContainer 对象多线�?
	 */
	private ThreadLocal<ResponseContainer> resConLocal = new ThreadLocal<ResponseContainer>();
	
	
    /**
     * ReponseData 对象多线程管�?
     */
	private ThreadLocal<ReponseData> rsDataLocal = new ThreadLocal<ReponseData>();



	public ResponseContainer getResponseContainer() {

		if (resConLocal.get() == null) {

			ResponseContainer con = new ResponseContainer();
			resConLocal.set(con);
			return con;
		} else {
			return resConLocal.get();
		}
	}

	public ReponseData getReponseData() {

		if (rsDataLocal.get() == null) {
			ReponseData rsdata = new ReponseData();
			rsDataLocal.set(rsdata);
			return rsdata;
		} else {
			return rsDataLocal.get();
		}
	}

	public ResponseContainer addResponse(int status, String msg, Object obj) {
		ResponseContainer res = this.getResponseContainer();
		ReponseData rsdata = this.getReponseData();
		res.setStatus(status);
		res.setMsg(msg);
		rsdata.setResult(obj);
		rsdata.resetPageInfo();// 清除分页相关信息
		res.setData(rsdata);
		return res;
	}

	public ResponseContainer addPageResponse(int status, String msg,
			ReponseData rspData, int mode, String md5) {
		ResponseContainer res = this.getResponseContainer();
		res.setStatus(status);
		res.setMsg(msg);
		res.setData(rspData);
		return res;
	}




}
