package com.danny.model;/**
 * Created by danny on 2017-11-22.
 */

import lombok.Data;

/**
 * @author danny
 * @create 2017-11-22 17:03
 */
@Data
public class ModifierSample {
    final String finalField = "final";
    static String staticField = "static";
    public String publicField = "public";
    protected String protectedField = "protected";
    String defaultField = "default";
    private String privateField = "private";


}
