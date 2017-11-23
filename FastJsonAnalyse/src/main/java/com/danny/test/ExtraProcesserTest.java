package com.danny.test;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.danny.common.MyExtraProcessor;
import com.danny.model.ExtraProcesserBean;
import org.junit.Assert;

/**
 * @author danny
 * @create 2017-11-23 16:54
 */

public class ExtraProcesserTest {
    public static void main(String[] args){
        ExtraProcessor processor = new MyExtraProcessor();
        ExtraProcesserBean bean = JSON.parseObject("{\"id\":123,\"name\":\"abc\"}", ExtraProcesserBean.class, processor);
        System.out.println(bean.getId());
        System.out.println(bean.getAttributes().get("name"));


        ExtraProcesserBean vo = JSON.parseObject("{\"id\":123,\"value\":\"123456\"}", ExtraProcesserBean.class, processor);
        System.out.println(vo.getId());
        System.out.println(vo.getAttributes().get("value").getClass());  // value本应该是字符串类型的，通过getExtraType的处理变成Integer类型了。


    }
}
