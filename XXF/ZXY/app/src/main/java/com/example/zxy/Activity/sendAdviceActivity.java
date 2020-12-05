package com.example.zxy.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zxy.Fragment.MyFragment1;
import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class sendAdviceActivity extends AppCompatActivity {

    TextView cancel,send;
    EditText title,content;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_advice);
        //Bmob.initialize(this,"e49aa2f7176954be57c1e57e6a14ab29");
        initView();
    }

    private void initView() {
        title = findViewById(R.id.title);
        content = findViewById(R.id.edit_content);
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sendAdviceActivity.this, MyFragment1.class);
                startActivity(intent);
            }
        });

        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    private void send() {
        xt_mail adviceAapter = new xt_mail();
        adviceAapter.setTitle(title.getText().toString());
        adviceAapter.setContent(content.getText().toString());
        adviceAapter.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Log.i("1","添加成功");
                }else {
                    Log.i("2","添加失败");
                }

            }
        });

    }



}
