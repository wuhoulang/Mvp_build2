package com.example.haoji.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lang.biao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/8/26.
 */

public class DrawerLayoutActivity extends Activity {
    private DrawerLayout drwl_id;
    private ListView lv_id;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        lv_id=findViewById(R.id.lv_id);
        drwl_id=findViewById(R.id.drwl_id);
        List<String> list =new ArrayList<>();
        for (int i = 0; i <5; i++) {
            list.add("王者荣耀"+i);
        }
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        lv_id.setAdapter(arrayAdapter);
    }
}
