package com.danny.test;/**
 * Created by danny on 2017-11-23.
 */

import com.alibaba.fastjson.JSONPath;
import lombok.Data;
import org.junit.Assert;

/**
 * @author danny
 * @create 2017-11-23 16:17
 */

public class JSONPathTest {
    @Data
    static class Entity {
        private Integer id;
        private String name;
        private Object value;
        public Entity() {}
        public Entity(Integer id, Object value) { this.id = id; this.value = value; }
        public Entity(Integer id, String name) { this.id = id; this.name = name; }
        public Entity(String name) { this.name = name; }
    }

    public static void main(String[] args){
        Entity entity = new Entity(123, new Object());

        Assert.assertSame(entity.getValue(), JSONPath.eval(entity, "$.value"));
        Assert.assertTrue(JSONPath.contains(entity, "$.value"));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.id", 123));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.value", entity.getValue()));
        Assert.assertEquals(2, JSONPath.size(entity, "$"));
        Assert.assertEquals(0, JSONPath.size(new Object[0],"$"));


    }

}
