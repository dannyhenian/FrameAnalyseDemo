package com.danny.common;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.danny.model.ExtraProcesserBean;

import java.lang.reflect.Type;

/**
 * 反序列化自定义
 * @author danny
 * @create 2017-11-23 16:46
 */

public class MyExtraProcessor implements ExtraProcessor , ExtraTypeProvider {

//    使用ExtraProcessor 处理多余字段
    public void processExtra(Object object, String key, Object value) {
        ExtraProcesserBean bean = (ExtraProcesserBean)object;
        bean.getAttributes().put(key, value);   //将多余的字段，存放在map中
    }

//    使用ExtraTypeProvider 为多余的字段提供类型
    public Type getExtraType(Object object, String key) {
        if ("value".equals(key)) {     //设置json中多余的value字段的值为int类型
            return int.class;
        }
        return null;
    }



}
