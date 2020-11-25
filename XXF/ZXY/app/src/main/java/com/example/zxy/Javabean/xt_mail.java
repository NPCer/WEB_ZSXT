package com.example.zxy.Javabean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;


public class xt_mail extends BmobObject implements Serializable {
    private String title;  //意见标题
    private String content;  //意见内容
    private int type_id;  //意见类别
    private int user_id;  //用户id
    private int dept_id;  //所属部门
    private Boolean is_over;  //是否完结（0：未完结 1：已完结）
    private Boolean is_anno;  //是否匿名（0：实名 1：匿名）
    private String reply;  //意见回复内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Boolean getIs_over() {
        return is_over;
    }

    public void setIs_over(Boolean is_over) {
        this.is_over = is_over;
    }

    public Boolean getIs_anno() {
        return is_anno;
    }

    public void setIs_anno(Boolean is_anno) {
        this.is_anno = is_anno;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Object setContent() {
        return content;
    }
}
