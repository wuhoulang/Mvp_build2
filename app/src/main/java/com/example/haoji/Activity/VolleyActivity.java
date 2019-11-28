package com.example.haoji.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lang.biao.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HAOJI on 2019/8/12.
 */

public class VolleyActivity extends Activity {
    private Button id_bt2;
    private Context context =VolleyActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley);
        id_bt2=findViewById(R.id.id_bt2);
        RequestQueue mQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest =new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("TAG", s);
                try {
                    JSONObject jsonObject =new JSONObject(s);
                    String code = jsonObject.getString("Code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", error.getMessage(),error);
            }
        });

        mQueue.add(stringRequest);
    }
}
