package com.example.examplerest.exception;

import lombok.Data;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplerest.exception
 * @author:yanggaoli
 * @createTime:2021/9/15 0:16
 * @version:1.0
 */
@Data
public class SubMyException extends MyException{
    Integer errCode;
    String errMsg;

    public SubMyException(){
        super();
    }

    public SubMyException(String errMsg){
        super(errMsg);
        this.errCode = 201;
        this.errMsg = errMsg;

    }
    public SubMyException(Integer errCode,String errMsg){
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = "自异常{SubMyException}"+errMsg;

    }
}
