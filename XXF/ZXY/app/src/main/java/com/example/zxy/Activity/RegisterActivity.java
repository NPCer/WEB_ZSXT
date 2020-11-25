package com.example.zxy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zxy.Javabean.xt_user;
import com.example.zxy.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {


    private EditText name;
    private EditText dept_id;
    private EditText is_leader;
    private EditText password;
    private Button btn_signup;
    private EditText ed_reEnterPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {

        ed_reEnterPassword = findViewById(R.id.input_reEnterPassword);
        name = findViewById(R.id.name);
        dept_id = findViewById(R.id.dept_id);
        is_leader = findViewById(R.id.is_leader);
        password = findViewById(R.id.password);
        btn_signup = findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }

    public void signup() {

//        if (!validate()) {
//            onSignupFailed();
//            Log.i("htht", "signup: 直接退出了");
//            return;
//        }

        btn_signup.setEnabled(false);

//        String Name = name.getText().toString();
//        String str = dept_id.getText().toString();
//        String str1 = is_leader.getText().toString();
//        String str2 = password.getText().toString();
//        String reEnterPassword = ed_reEnterPassword.getText().toString();

//        xt_user user = new xt_user();
//        user.setUsername(Name);
//        user.setPassword(str2);
//        user.setDept_id(Integer.parseInt(str));
//        user.setIs_leader(Boolean.parseBoolean(str1));
//        user.signUp(new SaveListener<xt_user>() {
//            @Override
//            public void done(xt_user user, BmobException e) {
//                if(e==null){
//                    onSignupSuccess();
//                } else {
//                    onSignupFailed();
//                }
//
//            }
//        });


        xt_user user = new xt_user();
        String Name = name.getText().toString();
        user.setUsername(Name);
        String str = dept_id.getText().toString();
        if(str == null){
            Toast.makeText(RegisterActivity.this,"部门不能为空！",Toast.LENGTH_SHORT).show();
        }
        else {
            user.setDept_id(Integer.parseInt(str));
        }

        String str1 = is_leader.getText().toString();
        if(str1 == null){
            Toast.makeText(RegisterActivity.this,"是否组长不能为空！",Toast.LENGTH_SHORT).show();
        }
        else {
            user.setIs_leader(Boolean.parseBoolean(str1));
        }


        String str2 = password.getText().toString();
        if(str1 == null){
            Toast.makeText(RegisterActivity.this,"密码不能为空！",Toast.LENGTH_SHORT).show();
        }
        else {
            user.setPassword(str2);
        }


        user.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Log.i("1","添加成功");
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    Log.i("2","添加失败");
                }
            }
        });
    }

    private void onSignupSuccess() {
        btn_signup.setEnabled(true);
        Intent intent = new Intent();
        // 获取用户计算后的结果
        String mobile =name.getText().toString();
//        intent.putExtra("name", name);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void onSignupFailed() {
        btn_signup.setEnabled(true);
    }

    public boolean validate() {

        boolean valid = true;
        String Name = name.getText().toString();
        String str = dept_id.getText().toString();
        String str1 = is_leader.getText().toString();
        String str2 = password.getText().toString();
        String reEnterPassword = ed_reEnterPassword.getText().toString();

        if (Name.isEmpty()|| Name.length() > 10) {
            name.setError("请输入小于10位用户名");
            valid = false;
        } else {
            name.setError(null);
        }

//        if (str.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
//            dept_id.setError("请输入你的部门");
//            valid = false;
//        } else {
//            dept_id.setError(null);
//        }

        if(str2.isEmpty() ){
            is_leader.setError("请输入验证码");
            valid = false;
        }else{
            is_leader.setError(null);
        }

        if (str2.isEmpty() || str2.length() < 4 || str2.length() > 10) {
            password.setError("请输入4到10位密码");
            valid = false;
        } else {
            password.setError(null);
        }

        if (reEnterPassword.isEmpty() || !(reEnterPassword.equals(str2))) {
            ed_reEnterPassword.setError("两次输入密码不一致");
            valid = false;
        } else {
            ed_reEnterPassword.setError(null);
        }


        Log.i("htht", "返回之前：valid ="+valid+"线程名       "+Thread.currentThread().getName());
        return valid;
    }
}
