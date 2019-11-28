package com.example.haoji.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HAOJI on 2019/7/26.
 */

public class StreamUtils {
    public static String readInputStream(InputStream is){
        try {
//            字节数组输出流 创建一个字节数组缓冲区,所有发送到输出流的数据保存在该字节数组缓冲区中
            //创建字节数组输出流 ，用来输出读取到的内容
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
//            定义一个字节数组,相当于缓存
            byte[] bytes =new byte[1024];
            int length =0;
//            把is里的东西读到bytes数组里去
            //开始读取输入流中的文件
            while ((length=is.read(bytes))!=-1){
                    bos.write(bytes,0,length);
            }
            is.close();
            bos.close();
            byte[] temp =bos.toByteArray();
//            字节转出String
            String result =new String(temp);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
