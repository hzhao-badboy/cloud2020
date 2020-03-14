package com.badboy.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResult<T> {

    private int code;
    private String msg;
    private T data;

}
