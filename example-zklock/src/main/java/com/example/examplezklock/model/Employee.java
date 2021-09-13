package com.example.examplezklock.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock.model
 * @author:yanggaoli
 * @createTime:2021/9/4 16:23
 * @version:1.0
 */
@Data
@Accessors(chain = true)
@Entity    //实体类注解
@Table(name="emp")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id    //设置主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增
    private long id;
    private String name;
    private boolean sex;
    private int age;
}
