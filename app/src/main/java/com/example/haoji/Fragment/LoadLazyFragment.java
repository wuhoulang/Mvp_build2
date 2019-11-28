package com.example.haoji.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HAOJI on 2019/9/30.
 */

public abstract class LoadLazyFragment extends Fragment {

    private View view;
    private boolean isVisibleToUser =false;
    private boolean hasLoaded =false;
    private boolean isCreated=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        init(getView(inflater,getLayoutId(),container),savedInstanceState);
        return view;
    }

    private void init(View view,Bundle savedInstanceState){
        isCreated =true;
        this.view = view;
        initview(view,savedInstanceState);
        lazyLoad(view,savedInstanceState);
        initData();
    }


    protected abstract void initData();

    public abstract void initview(View view,Bundle savedInstanceState);

    private void lazyLoad(View view, Bundle savedInstanceState) {

        //如果该界面不对用户显示、已经加载、fragment还没有创建，
        //三种情况任意一种，不获取数据
        if (!isVisibleToUser || hasLoaded || !isCreated) {
            return;
        }
        lazyinit(view ,savedInstanceState);
        //注：关键步骤，确保数据只加载一次
        hasLoaded = true;
    }



    private View getView(LayoutInflater inflater, int layoutId, ViewGroup container) {
        return inflater.inflate(layoutId, container, false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser=isVisibleToUser;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        hasLoaded = false;
    }

    public abstract void lazyinit(View view, Bundle saveInstanceState);

    public abstract int getLayoutId();
}
