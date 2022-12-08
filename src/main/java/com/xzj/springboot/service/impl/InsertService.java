package com.xzj.springboot.service.impl;

import com.xzj.springboot.dao.CarDao;
import com.xzj.springboot.entity.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class InsertService {

    @Resource CarDao carDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertOne(){
        Car car = new Car();
        car.setCarName("one");
        car.setPrice(10.0);
        carDao.insert(car);
    }


//    @Transactional(rollbackFor = Exception.class)
    public void insertTwo(){
        Car car = new Car();
        car.setCarName("two");
        car.setPrice(10.0);
        carDao.insert(car);
    }
}
