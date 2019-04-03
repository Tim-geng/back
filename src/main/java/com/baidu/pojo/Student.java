package com.baidu.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*更改日期格式*/
    @JSONField(format = "yyyy-MM-dd")
    public Date getDate(Date date) {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

