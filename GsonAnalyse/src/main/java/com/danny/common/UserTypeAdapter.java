package com.danny.common;
/**
 * Created by danny on 2017-11-22.
 */

import com.danny.model.User;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @author danny
 * @create 2017-11-22 17:22
 */

public class UserTypeAdapter extends TypeAdapter<User>{


    public void write(JsonWriter out, User value) throws IOException {
        out.beginObject();
        out.name("name").value(value.getName());
        out.name("age").value(value.getAge());
        out.name("email").value(value.getEmailAddress());
        out.endObject();
    }

    public User read(JsonReader reader) throws IOException {
        User user = new User();
        reader.beginObject();
        while (reader.hasNext()) {
            String s = reader.nextName();
            if(s.equals("name")){
                user.setName(reader.nextString());
            }  else if(s.equals("age")){
                user.setAge(reader.nextInt()); //自动转换
            } else if(s.equals("email") || s.equals("emailAddress") || s.equals("email_address") ){
                user.setEmailAddress(reader.nextString());
            }else {
                continue;
            }

            String str = "";
            switch (str){
                case "": break;
            }


        }
        reader.endObject();
        return user;


    }
}
