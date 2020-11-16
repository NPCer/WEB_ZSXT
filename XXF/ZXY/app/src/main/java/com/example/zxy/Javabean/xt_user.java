package com.example.zxy.Javabean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

public class xt_user extends BmobObject implements Serializable {

    private int id;
    private String password;
    private String name;
    private int dept_id;
    private Boolean is_leader;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Boolean getIs_leader() {
        return is_leader;
    }

    public void setIs_leader(Boolean is_leader) {
        this.is_leader = is_leader;
    }
}
