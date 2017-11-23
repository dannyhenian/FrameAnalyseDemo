package com.danny.test;/**
 * Created by danny on 2017-11-22.
 */

import com.danny.model.Category;
import com.danny.model.ModifierSample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author danny
 * @create 2017-11-22 16:47
 */

public class ExposeTest {
    public static void main(String[] args){
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Category category = new Category(0,"张1");
        Category category1 = new Category(1,"张2");
        Category category2 = new Category(2,"张三");

        List<Category> list = new ArrayList<Category>();
        list.add(category2);

        category1.setParent(category);
        category1.setChildren(list);

        String json = gson.toJson(category1);
        System.out.println(json);

        ModifierSample modifierSample = new ModifierSample();
        Gson gson2 = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.STATIC, Modifier.PRIVATE)  //禁用修饰符 final/static/private
                .create();
        System.out.println(gson2.toJson(modifierSample));


    }
}
