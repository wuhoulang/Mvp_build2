package com.example.haoji.Fragment.show_book;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class ShowTwoFragment extends Fragment {

    private Context context;
    private View view;
    private Button bt_video;

    @SuppressLint("ValidFragment")
    public ShowTwoFragment(Context context){
        this.context=context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.show_two,container,false);
        initview();
        return view;
    }

    private void initview() {
         bt_video=view.findViewById(R.id.bt_video);
        bt_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,VideoViewActivity.class);
                startActivity(intent);
            }
        });
    }

}
