package com.transn.houtai.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xuxiaohe on 2016/11/9.
 */
@Entity
@Table(name="service_category")
public class transncategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String firstgroup;

    private String secondgroup;

    private String name;

    private String bigimage;

    private String smallimage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstgroup() {
        return firstgroup;
    }

    public void setFirstgroup(String firstgroup) {
        this.firstgroup = firstgroup;
    }

    public String getSecondgroup() {
        return secondgroup;
    }

    public void setSecondgroup(String secondgroup) {
        this.secondgroup = secondgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBigimage() {
        return bigimage;
    }

    public void setBigimage(String bigimage) {
        this.bigimage = bigimage;
    }

    public String getSmallimage() {
        return smallimage;
    }

    public void setSmallimage(String smallimage) {
        this.smallimage = smallimage;
    }
}
