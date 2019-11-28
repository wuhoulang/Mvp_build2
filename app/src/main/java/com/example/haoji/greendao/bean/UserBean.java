package com.example.haoji.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by HAOJI on 2019/10/31.
 */
@Entity
public class UserBean {
    @Id
    long id;
    String name;
    int password;

    @Keep
    public UserBean(long id,String name,int password){
        this.id=id;
        this.name=name;
        this.password=password;
    }


    @Generated(hash = 1203313951)
    public UserBean() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
