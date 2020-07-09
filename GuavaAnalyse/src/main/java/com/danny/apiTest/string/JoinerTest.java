package com.danny.apiTest.string;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * 实用加入对象，字符串等。
 *
 * @author danny
 * @create 2017-12-22 17:58
 */

public class JoinerTest {
    public static void main(String[] args) {
        JoinerTest test = new JoinerTest();
        test.testJoiner();

    }
    private void testJoiner(){
        System.out.println(Joiner.on("#")
                .skipNulls()
                .join(Arrays.asList(1,2,3,4,5,null,6)));
    }
}
