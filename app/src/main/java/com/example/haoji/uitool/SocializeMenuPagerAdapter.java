package com.example.haoji.uitool;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cloud on 17/1/13.
 */

class SocializeMenuPagerAdapter extends PagerAdapter {
    private List<SnsPlatform[][]> mPageData;
    private Context mContext;
    private ShareBoardMenuHelper mMenuHelper;

    public SocializeMenuPagerAdapter(Context context, ShareBoardConfig shareBoardConfig) {
        this(context, shareBoardConfig, (List)null);
    }

    public SocializeMenuPagerAdapter(Context context, ShareBoardConfig shareBoardConfig, List<SnsPlatform> data) {
        this.mPageData = new ArrayList();
        this.mContext = context;
        this.mMenuHelper = new ShareBoardMenuHelper(shareBoardConfig);
        this.setData(data);
    }

    public void setData(List<SnsPlatform> data) {
        this.mPageData.clear();
        if(data != null) {
            this.mPageData.addAll(this.mMenuHelper.formatPageData(data));
        }

        this.notifyDataSetChanged();
    }

    public int getCount() {
        return this.mPageData == null?0:this.mPageData.size();
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.mMenuHelper.createPageLayout(this.mContext, (SnsPlatform[][])this.mPageData.get(position));
        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}