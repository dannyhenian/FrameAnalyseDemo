package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.danny.model.Result;
import com.danny.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 泛型使用
 * @author danny
 * @create 2017-11-22 15:20
 */

public class TypeTokenTest {

    public static void main(String[] args) {
        String json = "{\"code\":\"0\",\"message\":\"success\"," +
                "\"data\":{\"name\":\"怪盗kidou\",\"age\":24,\"email_address\":\"ikidou@example.com\"}}";

        String json1 = "{\"code\":0,\"message\":\"success\"," +
                "\"data\":[{\"name\":\"怪盗kidou\",\"age\":24,\"email_address\":\"ikidou@example.com\"}]}";


        Gson gson = new Gson();

        //不再重复定义Result类
        Type userType = new TypeToken<Result<User>>(){}.getType();
        System.out.println(userType);
        Result<User> userResult = gson.fromJson(json, userType);
        User user = userResult.getData();
        System.out.println(user);
        System.out.println(userResult);

        Type userlistType = new TypeToken<Result<List<User>>>(){}.getType();
        Result<List<User>> userListResult  = gson.fromJson(json1,userlistType);
        List<User> users = userListResult.getData();
        System.out.println(userListResult);
        System.out.println(users);


        System.out.println(gson.toJson(userResult));
        System.out.println(gson.toJson(userListResult));



    }
}
