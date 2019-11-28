package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
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
import com.example.haoji.view.LoadingDialog;
import com.example.lang.biao.R;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HAOJI on 2019/11/26.
 */

public class LoginActivity extends Activity implements ProgreesView {
    @BindView(R.id.bt_login2)
    Button bt_login2;

    @BindView(R.id.et_account2)
    EditText et_account2;

    @BindView(R.id.et_password2)
    EditText et_password2;

    private Context context = LoginActivity.this;
    private BiaoUser biaoUser;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        et_password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e("LoginActivity", "--setOnEditorActionListener---"+et_password2.getText().toString());
                if (!et_password2.getText().toString().equals("")){
                    if (bt_login2.getBackground().getAlpha()!=1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                bt_login2.setAlpha(1.0f);
                            }
                        });
                    }
                }else if (et_password2.getText().toString().equals("")) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bt_login2.setAlpha(0.3f);
                        }
                    });
                }
            }
        });

        loadingDialog = new LoadingDialog(context,"加载中...");
        biaoUser = new BiaoUser(this);
    }

    @OnClick(R.id.bt_login2)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login2:
                if (et_account2.getText().toString().equals("")||et_password2.getText().toString().equals("")){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "所输账号或密码不能为空", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    });
                }
                String account = et_account2.getText().toString();
                String password = et_password2.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        login(account, password);
                    }
                }).start();
                Log.e("LoginActivity", "--onViewClicked---");
                break;
            default:
                break;
        }
    }

    private void login(String account, String password) {
        biaoUser.getPostBean(context, ContentsJson.URL_LOGIN_BASE, account, password, new SuccessCallBack() {
            @Override
            public void IsSuccess(String data) {
                Log.e("LoginActivity", "-----response:" + data);
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    int code = jsonObject.getInt("Code");
                    if (code == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void IsFailed() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    });

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
