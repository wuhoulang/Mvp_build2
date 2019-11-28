package com.example.haoji.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by HAOJI on 2019/7/26.
 */

public class HttpUtils {
    public static String requestGet(String name,String passwored){
        String path ="";
        try {
            URL urL =new URL(path);
            HttpURLConnection con = (HttpURLConnection)urL.openConnection();
            //get 请求
            con.setConnectTimeout(5000);
            con.setRequestMethod("GET");
            con.setDoInput(true);

            //post 请求
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Charset","UTF-8");
//            con.setRequestProperty("Content-type","application/x-www-form-urlencoded");


            if (con.getResponseCode()==200) {
                InputStream is =con.getInputStream();
                String result =StreamUtils.readInputStream(is);
                return result;
            } else  {
                 return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
