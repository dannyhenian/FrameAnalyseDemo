package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.danny.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author danny
 * @create 2017-11-22 16:28
 */

public class GsonBuilderTest {
    public static void main(String[] args){
        Gson gson = new Gson();
        User user = new User("怪盗kidou",24);
        System.out.println(gson.toJson(user));

        Gson gson1 = new GsonBuilder()
                .serializeNulls()
                .create();
        User user1 = new User("怪盗kidou", 24);
        System.out.println(gson1.toJson(user1));


        Gson gson2 = new GsonBuilder()
                //序列化null
                .serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
                .setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
                .disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                //禁止转义html标签
                .disableHtmlEscaping()
                //格式化输出
                .setPrettyPrinting()
                .create();



    }
}
