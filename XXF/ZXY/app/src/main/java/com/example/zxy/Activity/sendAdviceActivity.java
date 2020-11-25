package com.example.zxy.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zxy.Fragment.MyFragment1;
import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class sendAdviceActivity extends AppCompatActivity {

    private RadioGroup type_id;
    private RadioGroup is_anno;
    private RadioButton type_1,type_2,type_3,type_yes,type_no;
    private TextView cancel,send;
    private int type;
    private Boolean anno;
    private EditText title,content;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_advice);
        //Bmob.initialize(this,"e49aa2f7176954be57c1e57e6a14ab29");
        initView();
    }

    private void initView() {
        type_id = findViewById(R.id.type_id);
        is_anno = findViewById(R.id.is_anno);
        type_1 = findViewById(R.id.type_1);
        type_2 = findViewById(R.id.type_2);
        type_3 = findViewById(R.id.type_3);
        type_yes = findViewById(R.id.type_yes);
        type_no = findViewById(R.id.type_no);
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
        type_id.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i == type_1.getId()){
                    type = 1;
                }else if(i == type_2.getId()){
                    type = 2;
                }else if(i == type_3.getId()){
                    type = 3;
                }
            }
        });

        is_anno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i == type_no.getId()){
                    anno = false;
                }else if(i == type_yes.getId()) {
                    anno = true;
                }
            }
        });
        Log.d("232323", String.valueOf(anno));
        Log.d("565656", String.valueOf(type));
        adviceAapter.setTitle(title.getText().toString());
        adviceAapter.setContent(content.getText().toString());
        adviceAapter.setDept_id(type);
        adviceAapter.setIs_anno(anno);
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
