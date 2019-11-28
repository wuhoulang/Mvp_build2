package com.example.haoji.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AssetUtils {

    public static String getAssetText(Context context) {
        InputStream is = null;
        String string = null;
        try {
            is = context.getResources().getAssets().open("abc.txt");
            byte[] bs = new byte[1024];
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            int length =0;
            while ((length=is.read(bs))!=-1){
                bos.write(bs,0,length);
            }
            byte[] buffer = bos.toByteArray();
            string = new String(buffer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return string;
    }

    public static Bitmap getBitmap(Context context){
        AssetManager amg = context.getAssets();
        Bitmap bitmap = null;
        try {
            InputStream is = amg.open("");
             bitmap = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
