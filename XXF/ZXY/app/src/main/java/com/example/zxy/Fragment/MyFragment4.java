package com.example.zxy.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.zxy.Activity.LoginActivity;
import com.example.zxy.R;

import cn.bmob.v3.BmobUser;

public class MyFragment4 extends Fragment {
    private Context context;
    private TextView tv_username;
    private TextView tv_dept_id;
    private TextView tv_is_leader;




    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4,container,false);
//        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
//        txt_content.setText("第4个Fragment");
//        Log.e("HEHE", "4ok");


        LinearLayout ll_logout = (LinearLayout) view.findViewById(R.id.ll_logout);
        ll_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                BmobUser.logOut();   //清除缓存用户对象
                getActivity().finish();     //关闭当前个人中心页
            }
        });


        return view;



    }

}
