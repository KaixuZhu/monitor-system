package com.zr.monitor.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyJson<T> implements Serializable {
    private String status;
    private String message;
    private T data;
}
