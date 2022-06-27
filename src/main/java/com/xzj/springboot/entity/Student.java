package com.xzj.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    public Long id;

    public String name;

    public Date creatTime;

    public Date updateTime;
}
