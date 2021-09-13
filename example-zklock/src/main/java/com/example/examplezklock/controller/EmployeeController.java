package com.example.examplezklock.controller;


import com.example.examplezklock.dao.EmployeeRepository;
import com.example.examplezklock.model.Employee;
import com.example.examplezklock.service.MyTestService;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 594781919@qq.com
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CuratorFramework curatorFramework;

    @Autowired
    private MyTestService myTestService;

    @Value("${name:lalla}")
    private String name;

    @GetMapping("/emp/save")
    public Employee save(String name) {

		// 获取锁
        InterProcessSemaphoreMutex balanceLock = new InterProcessSemaphoreMutex(curatorFramework, "/zktest" + name);
        //InterProcessMutex testLock = new InterProcessMutex(curatorFramework, "/zktest" + name);

        Employee employee = new Employee();
        try {
        	// 执行加锁操作
            balanceLock.acquire();
            System.out.println("已经加锁了, name=" + name);

            employee.setName(name);
            if ("abc".equals(name)) {
                Thread.sleep(10000);
            }
            employee.setAge((int) (Math.random() * 100));
            employee.setSex(false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	// 释放锁资源
                balanceLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        employeeRepository.save(employee);

        return employee;
    }

    @GetMapping("/test/data")
    public int save(int count) {
        return myTestService.getCount(count);
    }

    @GetMapping("/get")
    public String getName() {
        return name;
    }
}
