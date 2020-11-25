package com.example.zxy.utils;

import android.util.Log;

import com.example.zxy.Javabean.xt_mail;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

public class AdviceUtil {

    private static Iadvice advice;

    public static void setAdviceListener(Iadvice advice1) {
        advice = advice1;
    }

    public interface Iadvice{
        void getAdviceList(List<xt_mail> list);
    }

    public static void queryContent() {
        String sql = "select content * from xt_mail";
        new BmobQuery<xt_mail>().doSQLQuery(sql, new SQLQueryListener<xt_mail>() {
            @Override
            public void done(BmobQueryResult<xt_mail> bmobQueryResult, BmobException e) {
                if(e == null) {
                    List<xt_mail> list = bmobQueryResult.getResults();
                    advice.getAdviceList(list);
                    if(list != null && list.size()>0) {
                        for(int i=0;i<list.size();i++);
                    }

                }else {
                    Log.i("1","查询错误");
                }
            }
        });
    }
}
