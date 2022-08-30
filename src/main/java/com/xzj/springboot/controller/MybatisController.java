package com.xzj.springboot.controller;

import com.xzj.springboot.common.response.Response;
import com.xzj.springboot.entity.Car;
import com.xzj.springboot.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(tags = {"03 mybaits 测试"})
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Resource
    CarService carService;

    @ApiOperation("批量插入数据")
    @PostMapping("批量插入数据")
    public Response batchInsert(){
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
//            car.builder().carName(String.valueOf(i)).price(10.0*i).build();
            car.setCarName(Integer.toString(i));
            car.setPrice(10.0);
            carList.add(car);
        }
        carService.saveBatch(carList);

        return new Response();
    }
}
