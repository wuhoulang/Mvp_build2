package com.example.haoji.Bean;

/**
 * Created by HAOJI on 2019/8/2.
 */

public class ItemBean {


    private String title ;
    private int ImageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "title='" + title + '\'' +
                ", ImageId=" + ImageId +
                '}';
    }



}
