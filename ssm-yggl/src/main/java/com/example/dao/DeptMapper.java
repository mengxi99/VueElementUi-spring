package com.example.dao;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();
    @Delete("delete from dept where id=#{id}")
    int delDeptId(Integer id);
    @Update("update dept set id=id ,name=#{name},createTime=#{createTime},updateTime=#{updateTime} where id=#{id}")
    int updateDept(Dept dept);
}
