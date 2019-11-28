package com.example.haoji.Application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.haoji.greendao.databases.DaoMaster;
import com.example.haoji.greendao.databases.DaoSession;
import com.example.haoji.utils.ScreenAdapter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by HAOJI on 2019/9/9.
 */

public class MyApplication2 extends Application {

    private RefWatcher mRefWatcher;
    public DaoSession daoSession;
    public DaoSession getDaoSession() {
        return daoSession;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
       mRefWatcher =LeakCanary.install(this);
        ScreenAdapter.setup(this);

        initGreenDao();


    }

    public void initGreenDao() {

    }



    public static RefWatcher getRefWatcher(Context context){
        MyApplication2 application2 = (MyApplication2) context.getApplicationContext();
        return  application2.mRefWatcher;
    }

}
