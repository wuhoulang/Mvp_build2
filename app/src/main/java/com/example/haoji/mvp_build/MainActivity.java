package com.example.haoji.mvp_build;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lang.biao.R;

public class MainActivity extends AppCompatActivity implements MvpView ,View.OnClickListener {
    private ProgressDialog progressDialog;
    private TextView text;
    private MvpPresenter presenter;
    private Button success,fail,exception;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        success=findViewById(R.id.success);
        fail=findViewById(R.id.fail);
        exception=findViewById(R.id.exception);
        success.setOnClickListener(this);
        fail.setOnClickListener(this);
        exception.setOnClickListener(this);
        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter
        presenter = new MvpPresenter(this);
    }
    public void getData(View view){
        presenter.getData("normal");
        Log.e("onclick","--------------");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showData(String data) {
        text.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {
        text.setText(msg);
    }

    @Override
    public void showErrorMessage() {
        text.setText("网络请求数据出现异常");
    }

    @Override
    public void onClick(View v) {
        //switch语句
        switch (v.getId()) {
            case R.id.success:
                presenter.getData("normal");
                Log.e("onclick","--------------");
                break;
            case R.id.fail:
                presenter.getData("failure");
                break;
            case R.id.exception:
                presenter.getData("error");
                break;
            default:
                break;
        }
    }
}
