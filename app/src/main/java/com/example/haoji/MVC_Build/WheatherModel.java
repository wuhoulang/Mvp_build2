package com.example.haoji.MVC_Build;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by HAOJI on 2019/9/10.
 */

public class WheatherModel {
    //http://apis.juhe.cn/simpleWeather/query
    public static void getWeather(Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest =new StringRequest("http://apis.juhe.cn/simpleWeather/query", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("String","--s:--"+s.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("onErrorResponse","--s:--");
            }
        });

        requestQueue.add(stringRequest);
    }

}
