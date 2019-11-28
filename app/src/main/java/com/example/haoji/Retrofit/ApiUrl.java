package com.example.haoji.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HAOJI on 2019/11/21.
 */

public interface ApiUrl {
//    http://120.78.186.81/api/values/5
    @GET("values/5")
    Call<NewBean> getRetrofit();

}
