package com.myapplication.xt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "xt_canteen_rsv")
public class Xt_canteen_rsv implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "canteen_id")
    private Long canteen_id;

    @Column(name = "dept_id")
    private Long dept_id;

    @Column(name = "user_num")
    private Long user_num;

    @Column(name = "reason")
    private String reason;

    @Column(name = "begin_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin_time;

    @Column(name = "end_time")
    @DateTimeFormat(pattern = "MM-dd")
    private Date end_time;

    @Column(name = "option")
    private String option;

    @Column(name = "status")
    private Boolean status;
}
