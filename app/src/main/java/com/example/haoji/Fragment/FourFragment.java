package com.example.haoji.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haoji.Bean.ItemBean;
import com.example.lang.biao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/8/22.
 */

public class FourFragment extends Fragment {
    private View view;
    private RecyclerView id_rv;
    private RecyclerView id5_ll;
    private List<ItemBean> list;
    private ItemBean itemBean;
    private int[] arr ={R.drawable.flower,R.drawable.flower,R.drawable.flower};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.four,container,false);
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
//        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(view.getContext());
//        id_rv.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL) );
//        id_rv.setLayoutManager(linearLayoutManager);
//         RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(list,view.getContext());
//        id_rv.setAdapter(recyclerViewAdapter);
        return view;

    }

    private void initview() {
        id_rv=view.findViewById(R.id.id_rv);
        list =new ArrayList<>();
        itemBean =new ItemBean();
    }
}
