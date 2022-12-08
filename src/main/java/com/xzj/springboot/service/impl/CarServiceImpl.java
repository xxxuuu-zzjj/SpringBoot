package com.xzj.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.springboot.dao.CarDao;
import com.xzj.springboot.entity.Car;
import com.xzj.springboot.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {

    @Resource InsertService insertService;

    @Transactional(rollbackFor = Exception.class)
    public void errorTest(){
        try {
            insertService.insertOne();
            insertService.insertTwo();
            System.out.println(10/0);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


}
