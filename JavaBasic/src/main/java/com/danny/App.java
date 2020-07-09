package com.danny;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String a = "222";
        System.out.println(a.hashCode());
        a="111";
        System.out.println(a.hashCode());
    }
}
