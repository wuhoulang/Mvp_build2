package com.example.haoji.Bean;

import java.io.Serializable;

/**
 * Created by HAOJI on 2019/10/23.
 */

public class GoodsBean implements Serializable {

    private String englishname;
    private String chinesename;
    private String picture;
    private String music;

    public GoodsBean (String chinesename,String englishname ,String picture,String music){
        this.englishname=englishname;
        this.chinesename=chinesename;
        this.picture=picture;
        this.music=music;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

}
