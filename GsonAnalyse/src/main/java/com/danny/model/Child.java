package com.danny.model;

import lombok.Data;

/**
 * @author danny
 * @create 2018-09-13 18:12
 */
@Data
public class Child extends Parent {
    private int age;
    public Child(){};

    public Child(String name,String sex,int age){
        super(name,sex);
        this.age = age;
    }
}
