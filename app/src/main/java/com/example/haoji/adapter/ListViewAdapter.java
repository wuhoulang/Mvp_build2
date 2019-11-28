package com.example.haoji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/9/4.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context context;

    private ListViewAdapter(Context context){
         this.context=context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder =new ViewHolder();
        if(convertView==null){
          convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
          holder.textView=convertView.findViewById(R.id.four_rt);
          convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    private class ViewHolder{
        TextView textView;
    }


}
