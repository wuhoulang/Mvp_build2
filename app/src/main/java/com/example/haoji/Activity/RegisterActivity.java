package com.example.haoji.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haoji.Class.BiaoUser;
import com.example.haoji.Interface.ProgreesView;
import com.example.haoji.Interface.SuccessCallBack;
import com.example.haoji.MyContents.ContentsJson;
import com.example.lang.biao.R;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HAOJI on 2019/11/26.
 */

public class RegisterActivity extends Activity implements ProgreesView {

    @BindView(R.id.bt_confirm_register)
    Button bt_confirm_register;

    @BindView(R.id.et_account)
    EditText et_account;

    @BindView(R.id.et_password)
    EditText et_password;
    private BiaoUser biaoUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e("RegisterActivity", "--setOnEditorActionListener---"+et_password.getText().toString());
                if (!et_password.getText().toString().equals("")){
                    if (bt_confirm_register.getBackground().getAlpha()!=1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                bt_confirm_register.setAlpha(1.0f);
                            }
                        });
                    }
                }else if (et_password.getText().toString().equals("")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bt_confirm_register.setAlpha(0.3f);
                        }
                    });
                }
            }
        });
         biaoUser =new BiaoUser(this);
    }

    @OnClick(R.id.bt_confirm_register)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_confirm_register:
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        register(account,password);
                    }
                }).start();
                Log.e("RegisterActivity","--onViewClicked---");
                break;
            default:
                break;
        }
    }

    private void register(String account ,String password) {
        biaoUser.getPostBean(RegisterActivity.this, ContentsJson.URL_REGISTER_BASE,account,password, new SuccessCallBack() {
            @Override
            public void IsSuccess(String data) {
                Log.e("LoginActivity", "-----response:" + data);
                try {
                    JSONObject jsonObject =new JSONObject(data);
                    int code = jsonObject.getInt("Code");
                    if (code==0){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void IsFailed() {

            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
