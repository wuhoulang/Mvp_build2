package com.example.haoji.Class;

/**
 * Created by HAOJI on 2019/11/19.
 */

public class MessageWrap {

    private final String message;

    private MessageWrap (String message){
        this.message = message;
    }

    public static MessageWrap getInstance(String message){
        MessageWrap messageWrap = new MessageWrap(message);
        return messageWrap;
    }

}
