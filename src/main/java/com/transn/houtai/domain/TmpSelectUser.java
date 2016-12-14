package com.transn.houtai.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xuxiaohe on 2016/11/3.
 */
@Entity
@Table(name="tmp_selectuserlist")
public class TmpSelectUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    //客户ID
    private int customerid;
    //议员id
    private int userid;

    private String usernumber;

    private String userlogo;

    private String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public String getUserlogo() {
        return userlogo;
    }

    public void setUserlogo(String userlogo) {
        this.userlogo = userlogo;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
