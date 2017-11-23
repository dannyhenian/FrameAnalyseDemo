package com.danny.model;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.danny.common.ModelValueSerializer;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * @author danny
 * @create 2017-11-23 15:54
 */

@Data
public class Model implements PropertyProcessable {
    @JSONField(serializeUsing = ModelValueSerializer.class)
    private int value;

    @JSONField(jsonDirect=true)   //当字段是字符串类型，里面是json格式数据，你希望直接输入，而不是经过转义之后再输出
    public String json;

    public Model(){}

//    返回property的类型，如果返回空，则由parser自行推断。
    public Type getType(String name) {
        if ("value".equals(name)) {
            return String.class;
        }
        return null;
    }

//     处理属性值
    public void apply(String name, Object value) {
        if("value".equals(name)){
            String str = value.toString().replace("元","");
            this.value = Integer.valueOf(str);

        }

    }
}
