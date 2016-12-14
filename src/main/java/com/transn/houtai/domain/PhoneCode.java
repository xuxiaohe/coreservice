package com.transn.houtai.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="user_phonecode")
public class PhoneCode implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private String phonenumber;
	private String phonecodes;
	private int isused;
	private String time;

	public String getPhonecodes() {
		return phonecodes;
	}

	public void setPhonecodes(String phonecodes) {
		this.phonecodes = phonecodes;
	}

	public int getId() {
		return id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public int getIsused() {
		return isused;
	}

	public String getTime() {
		return time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setIsused(int isused) {
		this.isused = isused;
	}

	public void setTime(String time) {
		this.time = time;
	}





}
