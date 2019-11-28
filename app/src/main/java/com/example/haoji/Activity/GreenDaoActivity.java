package com.example.haoji.Activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.haoji.greendao.bean.UserBean;
import com.example.haoji.greendao.databases.DaoMaster;
import com.example.haoji.greendao.databases.DaoSession;
import com.example.haoji.greendao.databases.UserBeanDao;
import com.example.lang.biao.R;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * Created by HAOJI on 2019/10/31.
 */

public class GreenDaoActivity extends Activity implements View.OnClickListener {

    private Button bt_login;
    private Button bt_search;
    private TextView et_Text;
    private UserBeanDao userBeanDao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initview();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        userBeanDao = daoSession.getUserBeanDao();
    }

    private void initview() {
        bt_login = findViewById(R.id.bt_login);
        bt_search = findViewById(R.id.bt_search);
        et_Text = findViewById(R.id.et_Text);
        bt_login.setOnClickListener(this);
        bt_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                UserBean userBean = new UserBean();
                userBean.setId(3);
                userBean.setName("nang");
                userBean.setPassword(1051);
                userBeanDao.insert(userBean);
//                new AsyncTask().execute();
                break;
            case R.id.bt_search:
                QueryBuilder qb = userBeanDao.queryBuilder();
                qb.where(UserBeanDao.Properties.Name.eq("nang"));//eq为等于,还有lt,le等比较方法;每个Dao的Properties里存有字段,如Text
                List<UserBean> data = qb.list();
                 Log.e("QY","name:"+data.get(0).getPassword());


//                userBeanDao.deleteAll();
//                userBeanDao.delete(new UserBean(x,x,x));//会根据id删除
//                userBeanDao.deleteAll();
//                userBeanDao.deleteInTx();//传入迭代器或数组
//                userBeanDao.deleteByKey();//根据id删除
//                userBeanDao.deleteByKeyInTx();//根据id删除,且可传入迭代器或数组

                break;
            default:
                break;
        }
    }

    public class AsyncTask extends android.os.AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            et_Text.setText("点击下载");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            int i = 0;
            while (true) {
                publishProgress(i);
                i = i + 1;
                if (i >= 100) {
                    break;
                }
                Log.e("Login", "i:" + i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e("Login", ",下载的进度:" + values[0] + "%");
            et_Text.setText("下载的进度：" + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
//            if ()
            Log.e("Login", ",下载的完成");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            Log.e("Login", ",下载取消");

        }
    }


}







