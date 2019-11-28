package com.example.haoji.mvp_build;

/**
 * Created by HAOJI on 2019/7/25.
 */

public class MvpPresenter {
    /**
     * 负责请求数据，并对数据请求的反馈进行处理。
     */

    private MvpView mView;

    public MvpPresenter(MvpView view){
        this.mView = view;
    }

    public void getData(String params){
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                mView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                mView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                mView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                mView.hideLoading();
            }
        });
    }
}
