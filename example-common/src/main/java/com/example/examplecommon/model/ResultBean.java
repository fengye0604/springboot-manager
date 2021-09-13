package com.example.examplecommon.model;

import lombok.Data;

@Data
public class ResultBean {
    private String code;
    private String message;
    private Object data;
}
