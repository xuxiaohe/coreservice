package com.transn.houtai.domain;

import javax.persistence.*;

/**
 * Created by xuxiaohe on 2016/12/16.
 */
@Entity
@Table(name="categorys")
public class Categorys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
