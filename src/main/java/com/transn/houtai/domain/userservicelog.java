package com.transn.houtai.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xuxiaohe on 2016/11/30.
 */
@Entity
@Table(name="user_service_log")
public class userservicelog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private int serviceid;
    private int ossuserid;
    private String ossusername;
    private String info;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public int getOssuserid() {
        return ossuserid;
    }

    public void setOssuserid(int ossuserid) {
        this.ossuserid = ossuserid;
    }

    public String getOssusername() {
        return ossusername;
    }

    public void setOssusername(String ossusername) {
        this.ossusername = ossusername;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
