package com.example.zxy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.R;

import java.util.List;

public class AdviceAdapter extends ArrayAdapter<xt_mail> {
    private int resourceId;


    public AdviceAdapter(Context context, int resource,List<xt_mail> objects) {
        super(context,resource,objects);
        resourceId =resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        xt_mail mail = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView title = view.findViewById(R.id.advice_title);
        TextView content = view.findViewById(R.id.advice_text);
        title.setText(mail.getTitle());
        content.setText(mail.getContent());
//        return convertView;
        return view;
    }


//
//    public final class Holder {
//        EditText title;
//        EditText content;
//    }

}
