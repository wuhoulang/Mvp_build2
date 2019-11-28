package com.example.haoji.Fragment.show_book;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class ShowFourFragment extends Fragment {

    private Context context;

    @SuppressLint("ValidFragment")
    public ShowFourFragment(Context context){
        this.context=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.show_four,container,false);
        return view;
    }


}
