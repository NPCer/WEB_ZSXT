package com.example.zxy.Model;

import android.util.Log;

import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.Model.impl.AdviceModelImpl;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class AdviceModel implements AdviceModelImpl {

    public static final int STATE_REFRESH = 0;// 下拉刷新
    public static final int STATE_MORE = 1;// 加载更多
    private int limit = 5; // 每页的数据


    public void getAdviceItem(int currPage, final int actionType, final BaseListener listener) {

        Log.i("htht", "pageN:" + currPage + " limit:" + limit + " actionType:"
                + actionType);

        BmobQuery<xt_mail> query = new BmobQuery<>();
        // 按时间降序查询
        query.include("Writer");
        query.order("-createdAt");
        // 如果是加载更多
        if (actionType == STATE_MORE) {
            // 跳过之前页数并去掉重复数据
            query.setSkip(currPage * limit);
        } else {
            // 下拉刷新
            currPage = 0;
            query.setSkip(currPage);
        }
        // 设置每页数据个数
        query.setLimit(limit);
        // 查找数据
        query.findObjects(new FindListener<xt_mail>() {
            @Override
            public void done(List<xt_mail> list, BmobException e) {
                if (e == null) {
                    Log.i("htht", "done: 查询成功：共   " + list.size() + "  条数据。");
                    listener.getSuccess(list);
                    if (list.size() > 0) {
                        if (actionType == STATE_REFRESH) {

                        }
                    } else if (actionType == STATE_MORE) {
                        Log.i("htht" ,"done:没有更多数据了 ");
                    } else if (actionType == STATE_REFRESH) {
                        Log.i("htht" ,"done:没有数据 ");
                    }
                } else {
                    Log.i("htht", "查询失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });

    }



    @Override
    public void getAdviceItem(final BaseListener listener) {
        BmobQuery<xt_mail> query = new BmobQuery<xt_mail>();
        query.order("-createdAt");
        query.findObjects( new FindListener<xt_mail>() {
            @Override
            public void done(List<xt_mail> list, BmobException e) {
                if (e == null) {
                    Log.i("htht", "done: 查询成功：共   " + list.size() + "  条数据。");
                    listener.getSuccess(list);
                } else {
                    Log.i("htht", "查询失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }
}
