package com.danny.apiTest.cache;/**
 * Created by danny on 2017-12-25.
 */

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author danny
 * @create 2017-12-25 14:47
 */

public class CacheUtil {

    public static void main(String[] args) throws ExecutionException {
        Person person = new Person();
        person.setAge(11);
        person.setName("tSun");
        System.out.println(CacheUtil.get("man"));
        CacheUtil.put("man", new Person("hopg", 123));
        System.out.println(CacheUtil.get("man"));
        System.out.println(CacheUtil.get("man"));

        System.out.println(CacheUtil.get("person").toString());
        CacheUtil.put("person", person);
        System.out.println(CacheUtil.get("person").toString());
        System.out.println(CacheUtil.get("person").toString());

        System.out.println(CacheUtil.get("woman"));
        CacheUtil.put("women", new Person("google", 666));
        System.out.println(CacheUtil.get("woman"));
        System.out.println(CacheUtil.get("woman"));
        System.out.println(CacheUtil.get("man"));
    }

    private static LoadingCache<Object, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(2)   //设置缓存池容量大小，即缓存个数
            .expireAfterAccess(24, TimeUnit.HOURS)
            .recordStats()
            .build(new CacheLoader<Object, Object>() {
                @Override
                public Object load(Object key) throws Exception {
                    return key;
                }
            });

    public static Object get(Object key) throws ExecutionException {
        Object var = cache.get(key);
    System.out.println("========="+var);
        if (var.equals(key)) {

            System.out.println("执行其他操作,查询该值");
            /**执行其他操作，获取值**/
            Object object = "Google.com.hk";
            put(key, object);
        } else {
            System.out.println("从Cache中取值....");
        }
        return cache.get(key);
    }

    public static void put(Object key, Object value) {
        cache.put(key, value);
    }

}

class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "名字='" + name + '\'' +
                ", 年纪=" + age +
                '}';
    }
}

