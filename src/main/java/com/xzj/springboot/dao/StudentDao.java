package com.xzj.springboot.dao;

import com.xzj.springboot.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentDao {

    @Insert("insert into student (name) values (#{name,jdbcType=VARCHAR})")
    void addStudent(Student student);

    @Update("update student set name=#{name} where id=#{id}")
    void updateStudent(Student student);
}
