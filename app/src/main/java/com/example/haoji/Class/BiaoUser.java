package com.example.haoji.Class;

import android.content.Context;

import com.example.haoji.Interface.FiveMethod;
import com.example.haoji.Interface.ModelCallback;
import com.example.haoji.Interface.ProgreesView;
import com.example.haoji.Interface.SuccessCallBack;

/**
 * Created by HAOJI on 2019/11/25.
 */

public class BiaoUser implements FiveMethod {

    public static BiaoUser biaoUser = null;

    private Context context;

    private SuccessCallBack successCallBack;

    public ProgreesView mView;

    public BiaoUser(ProgreesView view){
        this.mView = view;
    }

//    public static BiaoUser getInstance() {
//        biaoUser = null;
//        if (biaoUser == null) {
//            synchronized (BiaoUser.class) {
//                if (biaoUser == null) {
//                    biaoUser = new BiaoUser(mView);
//                    Log.e("FiveFragment","getInstance-------------------------:");
//                }
//                return biaoUser;
//            }
//        }
//        return null;
//    }


    @Override
    public void getDataBean(Context context, String url,SuccessCallBack successCallBack) {
        this.context = context;
        this.successCallBack = successCallBack;
        mView.showLoading();
        BeanModel.getModel(context,url ,new ModelCallback() {
            @Override
            public void onSuccess(String data) {
                mView.hideLoading();
                successCallBack.IsSuccess(data);
            }

            @Override
            public void onFailure(String msg) {
                mView.hideLoading();
                successCallBack.IsFailed();
            }
        });
    }

    @Override
    public void getPostBean(Context context, String url,String account ,String password, SuccessCallBack successCallBack) {
        mView.showLoading();
        BeanModel.requestPostOKhttp(context,url , account , password,new ModelCallback() {
            @Override
            public void onSuccess(String data) {
                mView.hideLoading();
                successCallBack.IsSuccess(data);
            }

            @Override
            public void onFailure(String msg) {
                mView.hideLoading();
                successCallBack.IsFailed();
            }
        });
    }
}
