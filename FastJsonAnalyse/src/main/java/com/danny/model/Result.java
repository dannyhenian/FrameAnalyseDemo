package com.danny.model;/**
 * Created by danny on 2017-11-22.
 */

import lombok.Data;

/**
 * @author danny
 * @create 2017-11-22 15:19
 */
@Data
public class Result<T> {

    private int code;

    private String message;

    private T data;  //T= User, List<User>

}
