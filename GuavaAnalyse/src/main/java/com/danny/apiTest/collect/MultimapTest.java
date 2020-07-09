package com.danny.apiTest.collect;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 一个扩展来映射接口，以便其键可一次被映射到多个值
 * @author danny
 * @create 2017-12-22 15:23
 */

public class MultimapTest {
    public static void main(String[] args) {
        Multimap<Integer,String> map = ArrayListMultimap.create();
        map.put(101,"A");
        map.put(102,"A");
        map.put(103,"C");
        map.put(104,"D");
        map.put(101,"E");
        map.put(102,"F");

        Set<Integer> set = map.keySet();
        for(Integer s : set){
            System.out.println(s+"  " +map.get(s));
        }


        Collection<String> list = map.values();
        for(String s : list){
            System.out.println(s);
        }





    }
}
