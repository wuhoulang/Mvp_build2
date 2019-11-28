package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.haoji.Bean.ItemBean;
import com.example.haoji.adapter.RecyclerViewAdapter;
import com.example.lang.biao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/8/9.
 */

public class ReClerActivity extends Activity  {
    private RecyclerView id_rv;
    private int[] arr ={R.drawable.flower,R.drawable.flower,R.drawable.flower};
    private ItemBean itemBean;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Context context = ReClerActivity.this;
    private List<ItemBean> list;
    private LinearLayoutManager linearLayoutManager;
    private final String TAG = this.getClass().getName();
    private static final int myCode = 0x11;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
//        initview();
//        for (int i = 0; i < arr.length; i++) {
//            itemBean.setTitle("什么");
//            itemBean.setImageId(arr[i]);
//            list.add(itemBean);
//            Log.e("llll","-----"+list.size());
//        }
//        for (int i = 0; i < list.size(); i++) {
//            ItemBean itemBean = list.get(i);
//            Log.e("llll","---"+itemBean.getTitle()+"---"+itemBean.getImageId());
//        }
//        Log.e("llll","-----"+list.size());
//
//
//        linearLayoutManager = new LinearLayoutManager(this);
//        id_rv.setLayoutManager(linearLayoutManager);
//        recyclerViewAdapter =new RecyclerViewAdapter(list,context);
//        id_rv.setAdapter(recyclerViewAdapter);
    }

    private void initview() {
        id_rv=findViewById(R.id.id_rv);
        list =new ArrayList<>();
        itemBean =new ItemBean();
    }


}
