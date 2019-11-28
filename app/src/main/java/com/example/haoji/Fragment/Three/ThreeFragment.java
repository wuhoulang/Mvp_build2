package com.example.haoji.Fragment.Three;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.haoji.Activity.LoginActivity;
import com.example.haoji.Activity.RegisterActivity;
import com.example.haoji.Fragment.BaseFragment;
import com.example.haoji.Interface.OnItemClickListener;
import com.example.haoji.adapter.MeRecyclerViewAdapter;
import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/8/22.
 */

@SuppressLint("ValidFragment")
public class ThreeFragment extends BaseFragment implements View.OnClickListener {

    private Context context;
    private RecyclerView id_ry2;
    private Button bt_login, bt_register;

    @SuppressLint("ValidFragment")
    public ThreeFragment(Context context) {
        this.context = context;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.three, null);
        initview(view);
        return view;
    }

    private void initview(View view) {
        id_ry2 = view.findViewById(R.id.id_ry2);
        bt_login = view.findViewById(R.id.bt_login);
        bt_register = view.findViewById(R.id.bt_register);
        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        id_ry2.setLayoutManager(linearLayoutManager);
        MeRecyclerViewAdapter mv = new MeRecyclerViewAdapter(context);
        id_ry2.setAdapter(mv);
        mv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("onItemClick", "======position:" + position);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                Intent intent =new Intent(context, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_register:
                Intent intent2 =new Intent(context, RegisterActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
