package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 木木
 */
@RestController
public class LoginController {
    @Autowired
    private EmpServiceImpl empServiceImpl;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        Emp e=empServiceImpl.login(emp);
        return e!=null?Result.success(e):Result.error("账号或密码错误");
    }
}
