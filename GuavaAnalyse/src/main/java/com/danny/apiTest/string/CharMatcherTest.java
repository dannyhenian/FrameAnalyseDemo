package com.danny.apiTest.string;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.base.CharMatcher;

/**
 * 实用的字符操作。
 *
 * @author danny
 * @create 2017-12-22 17:59
 */

public class CharMatcherTest {
    public static void main(String[] args) {
        CharMatcherTest test = new CharMatcherTest();
        test.testCharMatcher();
    }

    private void testCharMatcher(){
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123")); // only the digits
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*")); // star out all digits
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh123"));
        // eliminate all characters that aren't digits or lowercase
    }
}
