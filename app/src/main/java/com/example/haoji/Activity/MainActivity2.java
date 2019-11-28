package com.example.haoji.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.haoji.Application.MyApplication2;
import com.example.haoji.Fragment.BaseFragment;
import com.example.haoji.Fragment.One.OneFragment;
import com.example.haoji.Fragment.Three.ThreeFragment;
import com.example.haoji.Fragment.Two.TwoFragment;
import com.example.haoji.PermissionUtils.PermissionsUtils;
import com.example.haoji.utils.ScreenAdapter;
import com.example.lang.biao.R;
import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/8/22.
 */

public class MainActivity2 extends FragmentActivity {
    private List<BaseFragment> fragments;
    private Context context = MainActivity2.this;
    private BottomNavigationView rg_main;
    private int position = 0;
    private BaseFragment mContext;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    private void initview() {
        RefWatcher refWatcher = MyApplication2.getRefWatcher(context);
        refWatcher.watch(this);
        ScreenAdapter.match(context, 360);
        setContentView(R.layout.viewpager);
        frameLayout = findViewById(R.id.frameLayout);
        rg_main = (BottomNavigationView) findViewById(R.id.rg_main);
        fragments = new ArrayList<>();
        OneFragment one = new OneFragment(context);
        ThreeFragment three = new ThreeFragment(context);
        TwoFragment two = new TwoFragment(context);
        fragments.add(one);
        fragments.add(two);
        fragments.add(three);
        initOnListener();
        rg_main.setSelectedItemId(R.id.one_rt);
        int i =0;
    }

    private void initOnListener() {
        rg_main.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.one_rt:
                        position = 0;
                        base();
                        return true;
                    case R.id.two_rt:
                        position = 1;
                        base();
                        return true;
                    case R.id.three_rt:
                        position = 2;
                        base();
                        return true;
                }
                return false;
            }
        });
    }

    private void base() {
        BaseFragment baseFragment = getFragment(position);
        switchFragment(mContext, baseFragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                        Log.e("switchFragment", "----11--------");
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                    Log.e("switchFragment", "----2222222--------");
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //就多一个参数this
        PermissionsUtils.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }


}
