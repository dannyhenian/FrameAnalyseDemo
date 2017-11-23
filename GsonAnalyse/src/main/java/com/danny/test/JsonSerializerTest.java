package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * http://www.jianshu.com/p/fc5c9cdf3aab
 * @author danny
 * @create 2017-11-22 17:39
 */

public class JsonSerializerTest {
    public static void main(String[] args) {

        JsonSerializer<Number> numberJsonSerializer = new JsonSerializer<Number>() {

            public JsonElement serialize(Number src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(String.valueOf(src));
            }
        };

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, numberJsonSerializer)
                .registerTypeAdapter(Long.class, numberJsonSerializer)
                .registerTypeAdapter(Float.class, numberJsonSerializer)
                .registerTypeAdapter(Double.class, numberJsonSerializer)
                .create();
        System.out.println(gson.toJson(100.0f));//结果："100.0"





    }
}
