package com.example.haoji.Activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.haoji.Bean.BiaoBean;
import com.example.haoji.Bean.GoodsBean;
import com.example.haoji.Fragment.One.ImageViewFragment;
import com.example.haoji.Service.MusicServices;
import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/10/17.
 */

public class SpeakActivity extends FragmentActivity implements View.OnClickListener {
    private BiaoBean.ContentBean biaoBean;
    private GoodsBean goodsBean;
    private TextView id_title;
    private Button btn_next, btn_last;
    private ContentLoadingProgressBar id_progressBar;
    private Context context = SpeakActivity.this;
    private int min;
    private ImageViewFragment imageViewFragment;
    private MusicServices service;
    private ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicServices.MyBinder myBinder = (MusicServices.MyBinder) iBinder;
            service = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_fragment);
        min = 20;
        id_title = findViewById(R.id.id_title);
        btn_last = findViewById(R.id.btn_last);
        btn_next = findViewById(R.id.btn_next);
        id_progressBar = findViewById(R.id.id_progressBar);
        btn_next.setOnClickListener(this);
        btn_last.setOnClickListener(this);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 15);
        goodsBean = (GoodsBean) intent.getSerializableExtra("name");
        if (goodsBean != null) {
            switch (position) {
                case 0:
                    id_title.setText("前元音");
                    break;
                case 1:
                    id_title.setText("中元音");
                    break;
                case 2:
                    id_title.setText("后元音");
                    break;
                case 3:
                    id_title.setText("开合双元音");
                    break;
                case 4:
                    id_title.setText("开合双元音");
                    break;
                case 5:
                    id_title.setText("爆破音");
                    break;
                case 6:
                    id_title.setText("浊辅音");
                    break;
                case 7:
                    id_title.setText("清辅音");
                    break;
                case 8:
                    id_title.setText("清辅音");
                    break;
                case 9:
                    id_title.setText("浊辅音");
                    break;
                case 10:
                    id_title.setText("清辅音");
                    break;
                case 11:
                    id_title.setText("浊辅音");
                    break;
                case 12:
                    id_title.setText("鼻音");
                    break;
                case 13:
                    id_title.setText("浊辅音");
                    break;
                default:
                    id_title.setText("元音");
                    break;
            }

        }
        imageViewFragment = new ImageViewFragment(goodsBean, context, service,position);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.id_imageview_show, imageViewFragment);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (min == 100) {
                    min = 20;
                } else {
                    min = min + 20;
                }
                id_progressBar.setProgress(min);
                break;
            case R.id.btn_last:
                if (min != 20) {
                    min = min - 20;
                    id_progressBar.setProgress(min);
                }
                break;
            default:
                break;
        }
    }
}
