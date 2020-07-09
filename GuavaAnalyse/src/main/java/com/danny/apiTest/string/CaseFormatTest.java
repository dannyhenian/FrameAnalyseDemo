package com.danny.apiTest.string;/**
 * Created by danny on 2017-12-22.
 */

import com.google.common.base.CaseFormat;

/**
 * 实用程序，用于改变字符串格式。
 *
 * @author danny
 * @create 2017-12-22 17:59
 */

public class CaseFormatTest {
    public static void main(String[] args) {
        CaseFormatTest test = new CaseFormatTest();
        test.testCaseFormat();
    }

    private void testCaseFormat(){
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }
}
