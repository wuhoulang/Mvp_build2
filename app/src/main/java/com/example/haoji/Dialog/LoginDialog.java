package com.example.haoji.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.lang.biao.R;


/**
 * Created by HAOJI on 2019/8/14.
 */

public class LoginDialog extends Dialog  {

    private TextView register_id;
    private Context context;

    public LoginDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    public LoginDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoginDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_dialog);
        initview();
        register_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterDialog rd =new RegisterDialog(context);
                rd.setCanceledOnTouchOutside(false);
                rd.show();
            }
        });
    }

    private void initview() {
        register_id=findViewById(R.id.register_id);
    }
}
