package com.danny.test;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.danny.model.Result;
import com.danny.model.User;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author danny
 * @create 2017-11-23 11:53
 */

public class TypeReferenceTest {
    public static void main(String[] args) {
        String json = "{\"code\":\"0\",\"message\":\"success\"," +
                "\"data\":{\"name\":\"怪盗kidou\",\"age\":24,\"email_address\":\"ikidou@example.com\"}}";

        String json1 = "{\"code\":0,\"message\":\"success\"," +
                "\"data\":[{\"name\":\"怪盗kidou\",\"age\":24,\"email\":\"ikidou@example.com\"}]}";



        Type userType = new TypeReference<Result<User>>() {}.getType();
        System.out.println(userType);
        Result<User>  userResult = JSON.parseObject(json,userType);
        User user = userResult.getData();
        System.out.println(user);
        System.out.println(userResult);

        Type userlistType = new TypeReference<Result<List<User>>>() {}.getType();
        Result<List<User>> userListResult  = JSON.parseObject(json,userlistType);
        List<User> users = userListResult.getData();
        System.out.println(userListResult);
        System.out.println(users);


        System.out.println(JSON.toJSON(userResult));
        System.out.println(JSON.toJSON(userListResult));

    }
}
