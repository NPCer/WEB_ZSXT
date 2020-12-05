package com.example.zxy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.zxy.Javabean.xt_mail;
import com.example.zxy.R;

import java.util.List;

public class AdviceAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<xt_mail> mDatas;
    private int mLayoutRes;
    private Context mContext;

    public AdviceAdapter(Context context,int layoutRes,List<xt_mail> datas) {
        this.mContext=context;
        this.mDatas=datas;
        this.mLayoutRes=layoutRes;
        mInflater = LayoutInflater.from(context);
    }

    public List<xt_mail> returnmDatas(){return this.mDatas;}
    public void addAll(List<xt_mail> mDatas) {this.mDatas.addAll(mDatas);}
    public void setDatas(List<xt_mail> mDatas){
        this.mDatas.clear();
        this.mDatas.addAll(mDatas);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null){
            convertView = mInflater.inflate(mLayoutRes, null);
            holder = new Holder();
            holder.title = (EditText) convertView.findViewById(R.id.title);
            holder.content = (EditText) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        xt_mail adviceAdapter = mDatas.get(position);
        final Holder viewHolder = holder;

        holder.title.setText(adviceAdapter.getTitle());
        holder.content.setText((adviceAdapter.getContent()));
        return convertView;
    }

    public final class Holder {
        EditText title;
        EditText content;
    }
}
