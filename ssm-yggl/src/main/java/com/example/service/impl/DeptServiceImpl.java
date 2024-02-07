package com.example.service.impl;

//import com.itheima.mapper.DeptMapper;
//import com.itheima.pojo.Dept;
//import com.itheima.pojo.Result;
//import com.itheima.service.DeptService;

import com.example.dao.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
     DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    public int delDeptId(Integer id) {
        return deptMapper.delDeptId(id);
    }

    public int update(Dept dept) {
        return deptMapper.updateDept(dept);
    }
}
