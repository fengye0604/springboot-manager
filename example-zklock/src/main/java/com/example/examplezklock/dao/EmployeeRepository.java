package com.example.examplezklock.dao;

import com.example.examplezklock.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @projectName:springboot-manager
 * @see:com.example.examplezklock.dao
 * @author:yanggaoli
 * @createTime:2021/9/4 16:58
 * @version:1.0
 */

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
