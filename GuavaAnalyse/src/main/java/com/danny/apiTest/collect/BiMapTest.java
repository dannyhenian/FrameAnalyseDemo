package com.danny.apiTest.collect;
/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Set;

/**
 * 个扩展来映射接口，支持反向操作。 value值必须唯一  inverse()反转（K、V）--》（V、K）
 * @author danny
 * @create 2017-12-22 15:23
 */

public class BiMapTest {
    public static void main(String[] args) {
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();

        empIDNameMap.put(new Integer(101), "Mahesh");
        empIDNameMap.put(new Integer(102), "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");
        empIDNameMap.put(new Integer(101), "C");
        empIDNameMap.put(new Integer(104), "A");
        empIDNameMap.put(new Integer(105), "B");

        Set<Integer>  set = empIDNameMap.keySet();
        for (Integer s : set) {
            System.out.println(s);
        }
        Set<String>  set1  = empIDNameMap.inverse().keySet();

        for (String s : set1) {
            System.out.println(s);
        }
        //Emp Id of Employee "Mahesh"
        System.out.println(empIDNameMap.inverse().get("A"));
    }

}
