package com.danny.model;/**
 * Created by danny on 2017-11-22.
 */

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

/**
 * @author danny
 * @create 2017-11-22 16:43
 */
@Data
public class Category {
    @Expose
    public int id;

    @Expose
    public String name;

    @Expose
    public List<Category> children;

    //因业务需要增加，但并不需要序列化
//    @Expose(deserialize = false,serialize = false)
    public Category parent;


    public Category(){}

    public Category(int id,String name){
        this.id = id;
        this.name = name;
    }


}
