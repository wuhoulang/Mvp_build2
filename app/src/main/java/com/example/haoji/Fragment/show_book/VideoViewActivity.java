package com.example.haoji.Fragment.show_book;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/11/22.
 */

public class VideoViewActivity extends Activity {

    private VideoView vv_teacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);
        vv_teacher =findViewById(R.id.vv_teacher);
        MediaController mediaController =new MediaController(this);
        vv_teacher.setMediaController(mediaController);
        vv_teacher.setVideoPath("https://flv2.bn.netease.com/videolib1/1811/26/OqJAZ893T/HD/OqJAZ893T-mobile.mp4");
        vv_teacher.start();
    }
}
