package com.danny.apiTest.math;/**
 * Created by danny on 2017-12-25.
 */

import com.google.common.math.IntMath;

import java.math.RoundingMode;


/**
 * @author danny
 * @create 2017-12-25 11:44
 */

public class IntMathTest {
    public static void main(String[] args) {
        IntMathTest test = new IntMathTest();
        test.testIntMath();

    }
    private void testIntMath(){
        try{
            System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE));
        }catch(ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(IntMath.divide(100, 5, RoundingMode.UNNECESSARY));
        try{
            //exception will be thrown as 100 is not completely divisible by 3 thus rounding
            // is required, and RoundingMode is set as UNNESSARY
            System.out.println(IntMath.divide(100, 3, RoundingMode.UNNECESSARY));
        }catch(ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Log2(2): "+IntMath.log2(2, RoundingMode.HALF_EVEN));

        System.out.println("Log10(10): "+IntMath.log10(10, RoundingMode.HALF_EVEN));

        System.out.println("sqrt(100): "+IntMath.sqrt(IntMath.pow(10,2), RoundingMode.HALF_EVEN));

        System.out.println("gcd(100,50): "+IntMath.gcd(100,50));  //最大公约数

        System.out.println("modulus(100,50): "+IntMath.mod(100,50));

        System.out.println("factorial(5): "+IntMath.factorial(5));  //返回 n!的累乘
    }
}
