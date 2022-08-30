package com.xzj.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzj.springboot.entity.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarDao extends BaseMapper<Car> {
}
