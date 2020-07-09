package com.danny.model;

import lombok.Data;

/**
 * @author danny
 * @create 2018-09-13 18:11
 */
@Data
public class Parent {
    private String name;
    private String sex;
    public Parent(){};
    public Parent(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
}
