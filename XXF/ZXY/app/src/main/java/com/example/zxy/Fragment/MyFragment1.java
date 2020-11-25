package com.example.zxy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.zxy.Activity.sendAdviceActivity;
import com.example.zxy.Adapter.AdviceAdapter;
import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.R;
import com.example.zxy.presenter.AdvicePresenter;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MyFragment1 extends Fragment {

    private int currPage;

    private AdvicePresenter mPresenter;
    private String s;
    private List<xt_mail> mList = new ArrayList<>();
    private String[] p = new String[16];
    private List<xt_mail> list1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment1, container, false);

        final ListView ListView = (ListView) view.findViewById(R.id.ListView);

  //     Bmob.initialize(this,"e49aa2f7176954be57c1e57e6a14ab29");
        BmobQuery<xt_mail> bmobQuery = new BmobQuery<xt_mail>();
        bmobQuery.findObjects(new FindListener<xt_mail>() {
            @Override
            public void done(java.util.List<xt_mail> list, BmobException e) {
                if(e==null) {
                    Log.d("path","查询成功");
                    Toast.makeText(getActivity(), "成功,共" + list.size() + "条数据", Toast.LENGTH_LONG).show();
                    AdviceAdapter adviceAdapter = new AdviceAdapter(getActivity(),R.layout.advice_item,list);
                    ListView ListView = (ListView) view.findViewById(R.id.ListView);
                    ListView.setAdapter(adviceAdapter);
                }
                else{
                    Log.d("path","查询不成功");
                }
            }
        });


//        AdviceUtil.queryContent();
//        AdviceUtil.setAdviceListener(new AdviceUtil.Iadvice() {
//            @Override
//            public void getAdviceList(List<xt_mail> list) {
//                if (list != null && list.size()>0) {
//                    for (int i=0;i<list.size();i++) {
//                        xt_mail advice = list.get(i);
//                        p[i] = advice.getContent().trim();
//                        Toast.makeText(getActivity(),advice.getContent(), Toast.LENGTH_SHORT).show();
//
//                        ArrayAdapter<String> adviceAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,p);
//                        ListView.setAdapter(adviceAdapter);
//
//
//                    }
//
//
//                }else {
//                    Log.i("哈哈哈","出错了");
//                }
//
//
//
//            }
//
//
//
//
//        });



        ImageView publish = (ImageView) view.findViewById(R.id.add);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sendAdviceActivity.class);
                getActivity().startActivity(intent);

            }
        });
        return view;


    }



}
