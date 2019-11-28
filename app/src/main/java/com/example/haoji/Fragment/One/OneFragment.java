package com.example.haoji.Fragment.One;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.example.haoji.Bean.BiaoBean;
import com.example.haoji.Bean.DataBean;
import com.example.haoji.Class.BiaoUser;
import com.example.haoji.Fragment.BaseFragment;
import com.example.haoji.Interface.ProgreesView;
import com.example.haoji.Interface.SuccessCallBack;
import com.example.haoji.MyContents.ContentsJson;
import com.example.haoji.adapter.RecyclerViewAdapter;
import com.example.lang.biao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOJI on 2019/8/22.
 */
@SuppressLint("ValidFragment")
public class OneFragment extends BaseFragment implements ProgreesView {
    private Context context;
    private RecyclerView id_rlv;
    private LinearLayoutManager manager;
    private RecyclerViewAdapter rva;
    private Activity mActivity;
    private List<BiaoBean> userList;
    private BiaoBean.ContentBean biaoBean1;
    private DataBean.LineOneBean.ContentBean data;
    private DataBean.LineTwoBean.ContentBeanX data2;
    private DataBean.LineThreeBean.ContentBeanXX data3;
    private DataBean.LineFourBean.ContentBeanXXX data4;
    private DataBean.LineFiveBean.ContentBeanXXXX data5;
    private DataBean.LineSixBean.ContentBeanXXXXX data6;
    private DataBean.LineSevenBean.ContentBeanXXXXXX data7;
    private DataBean.LineEightBean.ContentBeanXXXXXXX data8;
    private DataBean.LineNineBean.ContentBeanXXXXXXXX data9;
    private DataBean.LineTenBean.ContentBeanXXXXXXXXX data10;
    private DataBean.LineElevenBean.ContentBeanXXXXXXXXXX data11;
    private DataBean.LineTwelveBean.ContentBeanXXXXXXXXXXX data12;
    private DataBean.LineThirteenBean.ContentBeanXXXXXXXXXXXX data13;
    private DataBean.LineFourteenBean.ContentBeanXXXXXXXXXXXXX data14;
    private static final int CONTENT_INT = 1;
    private List<String> list_data;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == CONTENT_INT) {
                rva = new RecyclerViewAdapter(context, data, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11, data12, data13, data14);
                id_rlv.setAdapter(rva);
            }
            return false;
        }
    });
    private BiaoUser biaoUser;


    @SuppressLint("ValidFragment")
    public OneFragment(Context context) {
        this.context = context;
        Log.e("string", "-----------------------------");
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.one, null);
        id_rlv = view.findViewById(R.id.id_rlv);
        manager = new LinearLayoutManager(context);
        id_rlv.setLayoutManager(manager);
        list_data = new ArrayList<>();
         biaoUser =new BiaoUser(this);
        return view;
    }

    @Override
    public void initData() {
        getOkData();
    }


    private void getOkData() {
        Log.e("FiveFragment", "----2222222--------");
        String url = ContentsJson.BASE_ONE_JSON_DAN_ONE;
        biaoUser.getDataBean(context, url, new SuccessCallBack() {
            @Override
            public void IsSuccess(String data1) {
                Log.e("FiveFragment", "data1:" + data1);
                setBean1(data1);
                Message msg = new Message();
                msg.what = CONTENT_INT;
                mHandler.sendMessage(msg);
            }

            @Override
            public void IsFailed() {

            }
        });


        Log.e("string", "-------------getOkData----------------");

    }

    private void setBean(String s) {
        com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(s);
        //得到状态码
        String content = json.getString("content");
        com.alibaba.fastjson.JSONObject biaoBean = JSON.parseObject(content, BiaoBean.class);
        // 获取键值为 page_data 的json数组
        String page_data = biaoBean.getString("page_data");
        List<BiaoBean.ContentBean.PageDataBean> contentBeans = JSON.parseArray(page_data, BiaoBean.ContentBean.PageDataBean.class);
        biaoBean1 = new BiaoBean.ContentBean();
        biaoBean1.setPage_data(contentBeans);
    }

    private void setBean1(String s) {
        com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(s);

        //得到状态码
        String line_one = json.getString("line_one");
        String line_two = json.getString("line_two");
        String line_three = json.getString("line_three");
        String line_four = json.getString("line_four");
        String line_five = json.getString("line_five");
        String line_six = json.getString("line_six");
        String line_seven = json.getString("line_seven");
        String line_eight = json.getString("line_eight");
        String line_nine = json.getString("line_nine");
        String line_ten = json.getString("line_ten");
        String line_eleven = json.getString("line_eleven");
        String line_twelve = json.getString("line_twelve");
        String line_thirteen = json.getString("line_thirteen");
        String line_fourteen = json.getString("line_fourteen");


        com.alibaba.fastjson.JSONObject json1 = com.alibaba.fastjson.JSONObject.parseObject(line_one);
        com.alibaba.fastjson.JSONObject json2 = com.alibaba.fastjson.JSONObject.parseObject(line_two);
        com.alibaba.fastjson.JSONObject json3 = com.alibaba.fastjson.JSONObject.parseObject(line_three);
        com.alibaba.fastjson.JSONObject json4 = com.alibaba.fastjson.JSONObject.parseObject(line_four);
        com.alibaba.fastjson.JSONObject json5 = com.alibaba.fastjson.JSONObject.parseObject(line_five);
        com.alibaba.fastjson.JSONObject json6 = com.alibaba.fastjson.JSONObject.parseObject(line_six);
        com.alibaba.fastjson.JSONObject json7 = com.alibaba.fastjson.JSONObject.parseObject(line_seven);
        com.alibaba.fastjson.JSONObject json8 = com.alibaba.fastjson.JSONObject.parseObject(line_eight);
        com.alibaba.fastjson.JSONObject json9 = com.alibaba.fastjson.JSONObject.parseObject(line_nine);
        com.alibaba.fastjson.JSONObject json10 = com.alibaba.fastjson.JSONObject.parseObject(line_ten);
        com.alibaba.fastjson.JSONObject json11 = com.alibaba.fastjson.JSONObject.parseObject(line_eleven);
        com.alibaba.fastjson.JSONObject json12 = com.alibaba.fastjson.JSONObject.parseObject(line_twelve);
        com.alibaba.fastjson.JSONObject json13 = com.alibaba.fastjson.JSONObject.parseObject(line_thirteen);
        com.alibaba.fastjson.JSONObject json14 = com.alibaba.fastjson.JSONObject.parseObject(line_fourteen);


        String content = json1.getString("content");
        String content2 = json2.getString("content");
        String content3 = json3.getString("content");
        String content4 = json4.getString("content");
        String content5 = json5.getString("content");
        String content6 = json6.getString("content");
        String content7 = json7.getString("content");
        String content8 = json8.getString("content");
        String content9 = json9.getString("content");
        String content10 = json10.getString("content");
        String content11 = json11.getString("content");
        String content12 = json12.getString("content");
        String content13 = json13.getString("content");
        String content14 = json14.getString("content");


        com.alibaba.fastjson.JSONObject biaoBean = JSON.parseObject(content, DataBean.LineOneBean.class);
        com.alibaba.fastjson.JSONObject biaoBean2 = JSON.parseObject(content2, DataBean.LineTwoBean.class);
        com.alibaba.fastjson.JSONObject biaoBean3 = JSON.parseObject(content3, DataBean.LineThreeBean.class);
        com.alibaba.fastjson.JSONObject biaoBean4 = JSON.parseObject(content4, DataBean.LineFourBean.class);
        com.alibaba.fastjson.JSONObject biaoBean5 = JSON.parseObject(content5, DataBean.LineFiveBean.class);
        com.alibaba.fastjson.JSONObject biaoBean6 = JSON.parseObject(content6, DataBean.LineSixBean.class);
        com.alibaba.fastjson.JSONObject biaoBean7 = JSON.parseObject(content7, DataBean.LineSevenBean.class);
        com.alibaba.fastjson.JSONObject biaoBean8 = JSON.parseObject(content8, DataBean.LineEightBean.class);
        com.alibaba.fastjson.JSONObject biaoBean9 = JSON.parseObject(content9, DataBean.LineEightBean.class);
        com.alibaba.fastjson.JSONObject biaoBean10 = JSON.parseObject(content10, DataBean.LineEightBean.class);
        com.alibaba.fastjson.JSONObject biaoBean11 = JSON.parseObject(content11, DataBean.LineEightBean.class);
        com.alibaba.fastjson.JSONObject biaoBean12 = JSON.parseObject(content12, DataBean.LineEightBean.class);
        com.alibaba.fastjson.JSONObject biaoBean13 = JSON.parseObject(content13, DataBean.LineEightBean.class);
        com.alibaba.fastjson.JSONObject biaoBean14 = JSON.parseObject(content14, DataBean.LineEightBean.class);


        // 获取键值为 page_data 的json数组
        String page_data = biaoBean.getString("page_data");
        String page_data2 = biaoBean2.getString("page_data");
        String page_data3 = biaoBean3.getString("page_data");
        String page_data4 = biaoBean4.getString("page_data");
        String page_data5 = biaoBean5.getString("page_data");
        String page_data6 = biaoBean6.getString("page_data");
        String page_data7 = biaoBean7.getString("page_data");
        String page_data8 = biaoBean8.getString("page_data");
        String page_data9 = biaoBean9.getString("page_data");
        String page_data10 = biaoBean10.getString("page_data");
        String page_data11 = biaoBean11.getString("page_data");
        String page_data12 = biaoBean12.getString("page_data");
        String page_data13 = biaoBean13.getString("page_data");
        String page_data14 = biaoBean14.getString("page_data");

        List<DataBean.LineOneBean.ContentBean.PageDataBean> contentBeans = JSON.parseArray(page_data, DataBean.LineOneBean.ContentBean.PageDataBean.class);
        List<DataBean.LineTwoBean.ContentBeanX.PageDataBeanX> contentBeans2 = JSON.parseArray(page_data2, DataBean.LineTwoBean.ContentBeanX.PageDataBeanX.class);
        List<DataBean.LineThreeBean.ContentBeanXX.PageDataBeanXX> contentBeans3 = JSON.parseArray(page_data3, DataBean.LineThreeBean.ContentBeanXX.PageDataBeanXX.class);
        List<DataBean.LineFourBean.ContentBeanXXX.PageDataBeanXXX> contentBeans4 = JSON.parseArray(page_data4, DataBean.LineFourBean.ContentBeanXXX.PageDataBeanXXX.class);
        List<DataBean.LineFiveBean.ContentBeanXXXX.PageDataBeanXXXX> contentBeans5 = JSON.parseArray(page_data5, DataBean.LineFiveBean.ContentBeanXXXX.PageDataBeanXXXX.class);
        List<DataBean.LineSixBean.ContentBeanXXXXX.PageDataBeanXXXXX> contentBeans6 = JSON.parseArray(page_data6, DataBean.LineSixBean.ContentBeanXXXXX.PageDataBeanXXXXX.class);
        List<DataBean.LineSevenBean.ContentBeanXXXXXX.PageDataBeanXXXXXX> contentBeans7 = JSON.parseArray(page_data7, DataBean.LineSevenBean.ContentBeanXXXXXX.PageDataBeanXXXXXX.class);
        List<DataBean.LineEightBean.ContentBeanXXXXXXX.PageDataBeanXXXXXXX> contentBeans8 = JSON.parseArray(page_data8, DataBean.LineEightBean.ContentBeanXXXXXXX.PageDataBeanXXXXXXX.class);
        List<DataBean.LineNineBean.ContentBeanXXXXXXXX.PageDataBeanXXXXXXXX> contentBeans9 = JSON.parseArray(page_data9, DataBean.LineNineBean.ContentBeanXXXXXXXX.PageDataBeanXXXXXXXX.class);
        List<DataBean.LineTenBean.ContentBeanXXXXXXXXX.PageDataBeanXXXXXXXXX> contentBeans10 = JSON.parseArray(page_data10, DataBean.LineTenBean.ContentBeanXXXXXXXXX.PageDataBeanXXXXXXXXX.class);
        List<DataBean.LineElevenBean.ContentBeanXXXXXXXXXX.PageDataBeanXXXXXXXXXX> contentBeans11 = JSON.parseArray(page_data11, DataBean.LineElevenBean.ContentBeanXXXXXXXXXX.PageDataBeanXXXXXXXXXX.class);
        List<DataBean.LineTwelveBean.ContentBeanXXXXXXXXXXX.PageDataBeanXXXXXXXXXXX> contentBeans12 = JSON.parseArray(page_data12, DataBean.LineTwelveBean.ContentBeanXXXXXXXXXXX.PageDataBeanXXXXXXXXXXX.class);
        List<DataBean.LineThirteenBean.ContentBeanXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXX> contentBeans13 = JSON.parseArray(page_data13, DataBean.LineThirteenBean.ContentBeanXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXX.class);
        List<DataBean.LineFourteenBean.ContentBeanXXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXXX> contentBeans14 = JSON.parseArray(page_data14, DataBean.LineFourteenBean.ContentBeanXXXXXXXXXXXXX.PageDataBeanXXXXXXXXXXXXX.class);

        data = new DataBean.LineOneBean.ContentBean();
        data2 = new DataBean.LineTwoBean.ContentBeanX();
        data3 = new DataBean.LineThreeBean.ContentBeanXX();
        data4 = new DataBean.LineFourBean.ContentBeanXXX();
        data5 = new DataBean.LineFiveBean.ContentBeanXXXX();
        data6 = new DataBean.LineSixBean.ContentBeanXXXXX();
        data7 = new DataBean.LineSevenBean.ContentBeanXXXXXX();
        data8 = new DataBean.LineEightBean.ContentBeanXXXXXXX();
        data9 = new DataBean.LineNineBean.ContentBeanXXXXXXXX();
        data10 = new DataBean.LineTenBean.ContentBeanXXXXXXXXX();
        data11 = new DataBean.LineElevenBean.ContentBeanXXXXXXXXXX();
        data12 = new DataBean.LineTwelveBean.ContentBeanXXXXXXXXXXX();
        data13 = new DataBean.LineThirteenBean.ContentBeanXXXXXXXXXXXX();
        data14 = new DataBean.LineFourteenBean.ContentBeanXXXXXXXXXXXXX();

        data.setPage_data(contentBeans);
        data2.setPage_data(contentBeans2);
        data3.setPage_data(contentBeans3);
        data4.setPage_data(contentBeans4);
        data5.setPage_data(contentBeans5);
        data6.setPage_data(contentBeans6);
        data7.setPage_data(contentBeans7);
        data8.setPage_data(contentBeans8);
        data9.setPage_data(contentBeans9);
        data10.setPage_data(contentBeans10);
        data11.setPage_data(contentBeans11);
        data12.setPage_data(contentBeans12);
        data13.setPage_data(contentBeans13);
        data14.setPage_data(contentBeans14);
        Log.e("setBean1", "setBean1:" + "name:" + data.getPage_data().get(0).getChinesename());
        Log.e("setBean1", "goodsBean--music:" + data.getPage_data().get(0).getMusic());
    }


    public void lazyinit(View view, Bundle saveInstanceState) {
        Log.e("FiveFragment", "-----:");
    }


    public int getLayoutId() {
        return R.layout.one;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
