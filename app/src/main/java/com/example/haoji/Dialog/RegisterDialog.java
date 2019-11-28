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

public class RegisterDialog extends Dialog  {

    private TextView back;

    public RegisterDialog(@NonNull Context context) {
        super(context);
    }

    public RegisterDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected RegisterDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_dialog);
        initview();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               RegisterDialog.this.dismiss();
            }
        });
    }

    private void initview() {
        back=findViewById(R.id.back);
    }
}
