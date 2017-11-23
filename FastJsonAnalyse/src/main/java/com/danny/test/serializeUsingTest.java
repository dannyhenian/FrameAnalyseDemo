package com.danny.test;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.danny.model.Model;

/**
 * @author danny
 * @create 2017-11-23 15:58
 */

public class serializeUsingTest {


    public static void main(String[] args) {
        Model model = new Model();
        model.setValue(100);
        model.setJson("{}");
        String json = JSON.toJSONString(model, SerializerFeature.PrettyFormat);
        System.out.println(json);

        Model vo = JSON.parseObject(json,Model.class);
        System.out.println(vo);

    }
}
