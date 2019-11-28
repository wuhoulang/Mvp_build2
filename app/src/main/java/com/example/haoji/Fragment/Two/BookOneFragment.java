package com.example.haoji.Fragment.Two;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haoji.adapter.BookOneRecyclerViewAdapter;
import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class BookOneFragment extends Fragment {

    private Context context;

    @SuppressLint("ValidFragment")
    public BookOneFragment(Context context){
        this.context=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.book_one,container,false);
        initview(view);
        return view;
    }

    private void initview(View view) {
        RecyclerView ry = view.findViewById(R.id.ry_book);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        ry.setLayoutManager(manager);
        BookOneRecyclerViewAdapter bo =new BookOneRecyclerViewAdapter(context);
        ry.setAdapter(bo);
    }
}
