package com.danny.model;/**
 * Created by danny on 2017-11-23.
 */

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author danny
 * @create 2017-11-23 16:50
 */
@Data
public class ExtraProcesserBean {
    private int id;
    private Map<String, Object> attributes = new HashMap<String, Object>();

    public ExtraProcesserBean(){}
}
