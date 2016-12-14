package com.transn.houtai.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_active_log")
public class UserActiveLog implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private int userid;
	//日志信息
	private String info;
	//日志平台
	private String type;
	//日志接口
	private String interf;

	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInterf() {
		return interf;
	}

	public void setInterf(String interf) {
		this.interf = interf;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
