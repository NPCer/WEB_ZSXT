package com.example.zxy.Javabean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

public class xt_user extends BmobObject implements Serializable {

    private String password;
    private String username;
    private int dept_id;
    private Boolean is_leader;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserame() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
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
