package com.example.dao;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 木木
 */
@Mapper
public interface EmpDao {

    @Select("select * from emp")
    List<Emp> list();
    @Select("select count(*) from emp")
    Long count();
    @Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> page(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    @Select(
            "<script>"+
                    "select * from emp" +
                    "<where>" +
                    "<if test=\"name!=null and name!=''\">and name like CONCAT('%',#{name},'%')</if>" +
                    "<if test=\"gender!=null and gender!=''\">and gender like CONCAT('%',#{gender},'%')</if>" +
                    "</where>" +
                    "</script>"
    )
    List<Emp> selectByPageEmp(@Param("name") String name, @Param("gender") Short gender);




//    int addEmp(Emp emp);

    @Insert("insert into emp(id,username,name,gender,image,job,entrydate,deptId,createTime,updateTime) values(null,#{username},#{name},#{gender},null,#{job},null,#{deptId},null,null)")
    int addEmp(Emp emp);
}
