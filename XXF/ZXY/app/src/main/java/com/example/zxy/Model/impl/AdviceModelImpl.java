package com.example.zxy.Model.impl;

public interface AdviceModelImpl {


    void getAdviceItem(BaseListener listener);


    interface BaseListener<T> {
        void getSuccess(T t);

        void getFailure();
    }
}
