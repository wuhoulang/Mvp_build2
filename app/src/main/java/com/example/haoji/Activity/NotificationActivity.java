package com.example.haoji.Activity;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.lang.biao.R;

/**
 * Created by HAOJI on 2019/8/24.
 */

public class NotificationActivity extends Activity {
    private Button id_Bt;
    private Context context =NotificationActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        id_Bt=findViewById(R.id.id_Bt);
     id_Bt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Notification.Builder np =new Notification.Builder(context);
             Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
             PendingIntent mPendingIntent =PendingIntent.getActivity(context,0,intent,0);
             np.setContentIntent(mPendingIntent);
             np.setSmallIcon(R.drawable.flower);
             np.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.flower));
             np.setAutoCancel(true);
             np.setContentTitle("通知");
         }
     });
    }
}
