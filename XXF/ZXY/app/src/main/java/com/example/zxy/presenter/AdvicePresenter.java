package com.example.zxy.presenter;

import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.Model.AdviceModel;
import com.example.zxy.Model.impl.AdviceModelImpl;
import com.example.zxy.View.IAdvice;

import java.util.List;

public class AdvicePresenter {

    private AdviceModel mAdviceModel = new AdviceModel();
    private IAdvice mView;

    public AdvicePresenter(IAdvice mView) {
        this.mView = mView;
    }

    public AdvicePresenter() {
        this.mView = mView;
    }

    public void onRefresh(){
        mAdviceModel.getAdviceItem(0, AdviceModel.STATE_REFRESH, new AdviceModelImpl.BaseListener() {
            @Override
            public void getSuccess(Object o) {
                List<xt_mail> list= (List<xt_mail>) o;
                mView.onRefresh(list);
            }

            @Override
            public void getFailure() {

            }
        });
    }

    public void onLoadMore( int currPage){
        mAdviceModel.getAdviceItem(currPage, AdviceModel.STATE_MORE, new AdviceModelImpl.BaseListener() {
            @Override
            public void getSuccess(Object o) {
                List<xt_mail> list= (List<xt_mail>) o;
                mView.onLoadMore(list);
            }

            @Override
            public void getFailure() {

            }
        });
    }
}
