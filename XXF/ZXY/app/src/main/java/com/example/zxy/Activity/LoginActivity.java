package com.example.zxy.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zxy.Javabean.xt_user;
import com.example.zxy.R;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private TextView tv_reg;
    private EditText rg_name;
    private EditText rg_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        rg_name = findViewById(R.id.rg_name);
        rg_password = findViewById(R.id.rg_password);
        btn_login = findViewById(R.id.btn_Login);
        tv_reg = findViewById(R.id.tv_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tv_reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        btn_login.setEnabled(false);
        btn_login.setEnabled(false);
        //正在登陆提示框
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.Theme_AppCompat_DayNight_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("登陆中...");
        progressDialog.show();


        String name = rg_name.getText().toString();
        String password = rg_password.getText().toString();

        xt_user user = new xt_user();
        user.setUsername(name);
        user.setPassword(password);
//        user.login(new SaveListener<BmobUser>() {
//            @Override
//            public void done(BmobUser bmobUser, BmobException e) {
//                if(e==null) {
//                    Toast.makeText(LoginActivity.this,bmobUser.getUsername()+"登录成功",Toast.LENGTH_SHORT).show();
//                    // 允许用户使用应用
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    String errorMessage;
//                    switch (e.getErrorCode()){
//                        case 101:
//                            errorMessage = "用户名或者密码不正确";
//                            break;
//                        case 9016:
//                            errorMessage = "网都没有，你登陆个啥！！！";
//                            break;
//                        default:
//                            errorMessage = "登陆失败！";
//                            break;
//                    }
//                    Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_SHORT).show();
//                    Log.i("htht", "登陆时出错了 "+e.getErrorCode());
//                }
//            }
//        });

        if(name.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this,"账号密码都不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
    }

//    private void onLoginSuccess() {
//        btn_login.setEnabled(true);
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }

    private boolean validate() {
        boolean valid = true;

        String ed_name = rg_name.getText().toString();
        if (ed_name.isEmpty()) {
            rg_name.setError("请输入一个有效的手机号");
            valid = false;
        } else {
            rg_name.setError(null);
        }

        String password = rg_password.getText().toString();
        if (password.isEmpty()) {
            rg_password.setError("请输入4到10位密码");
            valid = false;
        } else {
            rg_password.setError(null);
        }
        return valid;
    }

    private void onLoginFailed() {
    }


}
