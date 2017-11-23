package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.danny.model.User;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.OutputStreamWriter;
import java.io.StringReader;

/**
 * @author danny
 * @create 2017-11-22 16:03
 */

public class JsonReaderTest {
    public static void main(String[] args) throws Exception{
        String json = "{\"name\":\"怪盗kidou\",\"age\":\"24\"}";
        User user = new User();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject(); // throws IOException
        while (reader.hasNext()) {
            String s = reader.nextName();
            if(s.equals("name")){
                user.setName(reader.nextString());
            }  else if(s.equals("age")){
                user.setAge(reader.nextInt()); //自动转换
            } else{
                user.setEmailAddress(reader.nextString());
            }

        }
        reader.endObject(); // throws IOException
        System.out.println(user.getName());  // 怪盗kidou
        System.out.println(user.getAge());   // 24
        System.out.println(user.getEmailAddress()); // ikidou@example.com

        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
        writer.beginObject() // throws IOException
                .name("name").value("怪盗kidou")
                .name("age").value(24)
                .name("email").nullValue() //演示null
                .endObject(); // throws IOException
        writer.flush(); // throws IOException




    }
}
