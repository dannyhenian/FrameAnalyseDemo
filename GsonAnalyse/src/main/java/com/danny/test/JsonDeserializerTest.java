package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author danny
 * @create 2017-11-22 17:43
 */

public class JsonDeserializerTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, new JsonDeserializer<Integer>() {

                    public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        try {
                            return json.getAsInt();
                        } catch (NumberFormatException e) {
                            return 0;
                        }
                    }
                })
                .create();
        System.out.println(gson.toJson(100)); //结果：100
        System.out.println(gson.fromJson("\"\"", Integer.class)); //结果-1

    }
}
