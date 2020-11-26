package com.miluyas.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private long id;
    private String content;
    private String add_time;
    private String deadline_time;


}
