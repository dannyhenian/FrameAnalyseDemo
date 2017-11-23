package com.danny.common;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author danny
 * @create 2017-11-23 15:55
 */

public class ModelValueSerializer implements ObjectSerializer {
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {

        Integer value = (Integer) object;
        String text = value + "元";
        serializer.write(text);
    }
}
