package com.example.haoji.Bean;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by HAOJI on 2019/10/19.
 */

public class BiaoBean extends JSONObject {


    /**
     * title : 元音节
     * content : {"page_data":[{"englishname":"fish","chinesename":"鱼","picture":"/1478770583835.png"},{"englishname":"egg","chinesename":"蛋","picture":"/1478770583835.png"},{"englishname":"dog","chinesename":"狗","picture":"/1478770583835.png"}]}
     */

    private String title;
    private ContentBean content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private List<PageDataBean> page_data;

        public List<PageDataBean> getPage_data() {
            return page_data;
        }

        public void setPage_data(List<PageDataBean> page_data) {
            this.page_data = page_data;
        }

        public static class PageDataBean {
            /**
             * englishname : fish
             * chinesename : 鱼
             * picture : /1478770583835.png
             */

            private String englishname;
            private String chinesename;
            private String picture;

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
        }
    }
}
