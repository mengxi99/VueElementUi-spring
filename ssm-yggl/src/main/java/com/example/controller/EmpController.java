package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 木木
 */
@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpServiceImpl empServiceImpl;

    //    @GetMapping("/emps")
    //查询全部员工
    public List<Emp> list(){
        List<Emp> empList=empServiceImpl.list();
        return empList;
    }

    //带分页查询员工
    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean=empServiceImpl.page(page,pageSize);
        return Result.success(pageBean);
    }

    //条件查询员工
    @GetMapping("/empBy")
     List<Emp> selectByPageEmp(String name,Short gender){
        List<Emp> empList=empServiceImpl.selectByPageEmp(name,gender);
        System.out.println("empList = " + empList);
        return empList;

    }
    //删除员工
    @GetMapping("delEmpId")
    public int delEmpId(Integer id){
        int i=empServiceImpl.delEmpId(id);
        return i;
    }

    //新增员工
    @GetMapping("/addEmp")
    public int addEmp(Emp emp){
//        System.out.println("username = " + username);
        System.out.println("emp = " + emp);

        int i=empServiceImpl.addEmp(emp);
        System.out.println("i = " + i);

        return i;
    }


    //更新员工
    @GetMapping("/updateEmp")
    public int updateEmp(Emp emp){
        int i=empServiceImpl.updateEmp(emp);
        return i;
    }
}
