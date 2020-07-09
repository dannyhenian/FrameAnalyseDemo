package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.danny.common.UserTypeAdapter;
import com.danny.model.Child;
import com.danny.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author danny
 * @create 2017-11-22 17:26
 */

public class TypeAdapterTest {
    public static void main(String[] args) {
        User user = new User("怪盗kidou", 24);
        user.setEmailAddress("ikidou@example.com");
        Gson gson = new GsonBuilder()
                //为User注册TypeAdapter
                .registerTypeAdapter(User.class, new UserTypeAdapter())
                .create();
        String json = gson.toJson(user);
        
        System.out.println(json);
        User vo = gson.fromJson(json,User.class);

        System.out.println(vo);

        Child child = new Child("nihao","man",16);
        String jsonChild = gson.toJson(vo);
        System.out.println(jsonChild);
        Child child1 = gson.fromJson(jsonChild,Child.class);
        System.out.println(child1);
        System.out.println(child1.getName());


    }
}
