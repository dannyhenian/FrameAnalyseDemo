package com.danny.model;/**
 * Created by danny on 2017-11-22.
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author danny
 * @create 2017-11-22 15:11
 */
@Data
//@JsonAdapter(UserTypeAdapter.class)
public class User {

    private String name;

    private int age;

//    @SerializedName(value = "email_address", alternate = {"email", "emailAddress"})
    @JSONField(name = "email_address", alternateNames = {"email", "emailAddress"})
    private String emailAddress;

    public User(){ }

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }
}
