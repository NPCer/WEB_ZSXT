package com.example.zxy.View;

import com.example.zxy.Javabean.xt_mail;

import java.util.List;

public interface IAdvice {

    void onLoadMore(List<xt_mail> list);

    void onRefresh(List<xt_mail> list);
}
