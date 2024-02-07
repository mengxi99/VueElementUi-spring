package com.example.service.impl;

import com.example.dao.EmpDao;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 木木
 */
@Service
public class EmpServiceImpl {
    @Autowired
    private EmpDao empDao;
    public List<Emp> list() {
        return empDao.list();
    }

    public PageBean page(Integer page,Integer pageSize) {
        Long count= empDao.count();
        Integer start=(page-1)*pageSize;
        List<Emp> empList=empDao.page(start,pageSize);
        PageBean pageBean=new PageBean(count,empList);
        return pageBean;
    }


    public List<Emp> selectByPageEmp(String name, Short gender) {
        return empDao.selectByPageEmp(name,gender);
    }


    public int addEmp(Emp emp) {
//        emp.setImage("a.jpg");
//        emp.setEntrydate("2024-02-07");
//        emp.setCreateTime("2024-02-07");
//        emp.setUpdateTime("2024-02-07");
        return empDao.addEmp(emp);
    }
}
