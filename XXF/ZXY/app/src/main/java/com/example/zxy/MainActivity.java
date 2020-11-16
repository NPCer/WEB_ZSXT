package com.example.zxy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zxy.Adapter.MyFragmentPagerAdapter;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener{

    private RadioGroup tab_menu;
    private RadioButton rbChat,rbAddress,rbFind,rbMe;
    private ViewPager vpager;
    private MyFragmentPagerAdapter mAdapter;

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"e49aa2f7176954be57c1e57e6a14ab29");

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rbChat.setChecked(true);

        rbChat = (RadioButton) findViewById(R.id.rbChat);
        rbAddress = (RadioButton) findViewById(R.id.rbAddress);
        rbFind = (RadioButton) findViewById(R.id.rbFind);
        rbMe = (RadioButton) findViewById(R.id.rbMe);
        tab_menu = (RadioGroup) findViewById(R.id.tab_menu);


        RadioButton[] rbs = new RadioButton[4];
        rbs[0] = rbChat;
        rbs[1] = rbAddress;
        rbs[2] = rbFind;
        rbs[3] = rbMe;
        for (RadioButton rb:rbs) {
            //挨着给每个RadioButton加入drawable限制边距以控制显示大小
            Drawable[] drawables = rb.getCompoundDrawables();
            //获取drawables
            Rect r = new Rect(0, 0, drawables[1].getMinimumWidth()*1/3, drawables[1].getMinimumHeight()*1/3);
            //定义一个Rect边界
            drawables[1].setBounds(r);
            //添加限制给控件
            rb.setCompoundDrawables(null,drawables[1],null,null);

        }
    }


    private void bindViews() {

        tab_menu = (RadioGroup) findViewById(R.id.tab_menu);
        rbChat = (RadioButton) findViewById(R.id.rbChat);
        rbAddress = (RadioButton) findViewById(R.id.rbAddress);
        rbFind = (RadioButton) findViewById(R.id.rbFind);
        rbMe = (RadioButton) findViewById(R.id.rbMe);
        tab_menu.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbChat:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rbAddress:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rbFind:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rbMe:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }
    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rbChat.setChecked(true);
                    break;
                case PAGE_TWO:
                    rbAddress.setChecked(true);
                    break;
                case PAGE_THREE:
                    rbFind.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rbMe.setChecked(true);
                    break;
            }
        }
    }
}


