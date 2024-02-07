package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    DeptServiceImpl deptServiceImpl;

    //查询所有部门
    @GetMapping("/depts")
    public Result list(){
        log.info("查询所有部门");
        List<Dept> deptList= deptServiceImpl.list();
        System.out.println("deptList = " + deptList);
        return Result.success(deptList);
    }

    //根据id删除部门
    @GetMapping("/delDeptId")
    public int delDeptId(Integer id){
        int i=deptServiceImpl.delDeptId(id);
        return i;
    }
    //更新部门
    @GetMapping("/updateDept")
    public int updateDept(Dept dept){
        int i=deptServiceImpl.update(dept);
        return i;
    }

}
