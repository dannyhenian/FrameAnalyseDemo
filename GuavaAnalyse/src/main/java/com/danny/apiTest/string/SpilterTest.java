package com.danny.apiTest.string;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.base.Splitter;

/**
 * 实用程序用来分割字符串。
 *
 * @author danny
 * @create 2017-12-22 17:58
 */

public class SpilterTest {
    public static void main(String[] args) {
        SpilterTest test = new SpilterTest();
        test.testSplitter();
    }

    private void testSplitter(){
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()  //去除空字符串
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }
}
