package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/8/14.
 */

public class GridViewActivity extends Activity {
    private GridView gridView,gridView2;
    private Context context=GridViewActivity.this;
    private int[] ins={R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initview();
        initdata();
    }

    private void initdata() {
//        GridViewAdapter gridViewAdapter =new GridViewAdapter(context,ins);
//        gridView.setAdapter(gridViewAdapter);
    }

    private void initview() {
        gridView=findViewById(R.id.id_gv);
        gridView2=findViewById(R.id.id_gv2);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("onItemClick","---:"+i);
            }
        });
    }


}
