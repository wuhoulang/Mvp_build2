package com.example.haoji.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/14.
 */

public class ProDialog extends Dialog  {

    private TextView register_id;
    private Context context;
    private Handler handler =new Handler();
    private int themeResId;
    public ProDialog(@NonNull Context context) {
        super(context);
        this.context=context;

    }

    public ProDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context=context;
        this.themeResId=themeResId;
    }

    protected ProDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginDialog loginDialog =new LoginDialog(context);
                loginDialog.setCanceledOnTouchOutside(false);
                loginDialog.show();
                ProDialog.this.dismiss();
            }
        },1000);

    }


}
