package com.example.haoji.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.haoji.Fragment.show_book.ShowFourFragment;
import com.example.haoji.Fragment.show_book.ShowOneFragment;
import com.example.haoji.Fragment.show_book.ShowThreeFragment;
import com.example.haoji.Fragment.show_book.ShowTwoFragment;
import com.example.haoji.adapter.ReadPagerAdapter;
import com.example.lang.biao.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HAOJI on 2019/11/6.
 */

public class ReadBookActivity extends FragmentActivity {

     private Context context =ReadBookActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_book);
        TabLayout tab_book_layout =findViewById(R.id.tab_book_layout);
        ViewPager show_book_vp =findViewById(R.id.show_book_vp);
        ShowOneFragment one = new ShowOneFragment(context);
        ShowTwoFragment two = new ShowTwoFragment(context);
        ShowThreeFragment three= new ShowThreeFragment(context);
        ShowFourFragment four= new ShowFourFragment(context);
        List<Fragment> list =new ArrayList<>();
        list.add(one);list.add(two);list.add(three);list.add(four);
        List<String> list1 =new ArrayList<>();
        String[] s ={"字幕听力","名师视频","配套练习","配套资源"};
        list1.addAll(Arrays.asList(s));
        android.support.v4.app.FragmentManager manager =getSupportFragmentManager();
        ReadPagerAdapter readPagerAdapter =new ReadPagerAdapter(context,list,manager,list1);
        show_book_vp.setAdapter(readPagerAdapter);
        tab_book_layout.setupWithViewPager(show_book_vp);
    }
}
