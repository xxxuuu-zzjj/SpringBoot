package com.xzj.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.springboot.dao.CarDao;
import com.xzj.springboot.entity.Car;
import com.xzj.springboot.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {
}
