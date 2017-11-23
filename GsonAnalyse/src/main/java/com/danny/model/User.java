package com.danny.model;/**
 * Created by danny on 2017-11-22.
 */

import com.danny.common.UserTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
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

    @SerializedName(value = "email_address", alternate = {"email", "emailAddress"})
    private String emailAddress;

    public User(){ }

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }
}
