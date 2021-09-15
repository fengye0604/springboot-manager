package com.example.examplerest.exception;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplerest.exception
 * @author:yanggaoli
 * @createTime:2021/9/15 0:02
 * @version:1.0
 */
public class MyException extends Exception{
    //public String message;
    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }
}
