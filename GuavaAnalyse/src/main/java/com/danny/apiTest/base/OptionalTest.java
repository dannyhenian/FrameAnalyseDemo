package com.danny.apiTest.base;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.base.Optional;

/**
 * @author danny
 * @create 2017-12-22 11:05
 */

public class OptionalTest {
    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }

    public Integer sum1(Integer a, Integer b) {
        return a + b;
    }


    public Integer sum2(Optional<Integer> a, Optional<Integer> b){
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

    public static void main(String[] args) {

       OptionalTest optionalTest = new OptionalTest();
       Integer invalidInput = null;
//       Optional<Integer> a = Optional.of(invalidInput);
//       Optional<Integer> b = Optional.of(new Integer(0));
//       System.out.println(optionalTest.sum(a,b));

//       Integer a =  null;
//       Integer b =  new Integer(10);
//       System.out.println(optionalTest.sum1(a,b));

       Integer value1 =  null;
       Integer value2 =  new Integer(10);
       Optional<Integer> a = Optional.fromNullable(value1);
       Optional<Integer> b = Optional.of(value2);

        System.out.println(optionalTest.sum2(a,b));
   }


}
