package com.xzj.springboot.controller;

import com.xzj.springboot.common.response.Response;
import com.xzj.springboot.dao.CarDao;
import com.xzj.springboot.entity.Car;
import com.xzj.springboot.service.CarService;
import com.xzj.springboot.service.impl.CarServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
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

    @Resource CarServiceImpl carService;
    @Resource CarDao carDao;

    @ApiOperation("批量插入数据")
    @PostMapping("批量插入数据")
    public Response batchInsert(){
        carService.errorTest();
        return new Response();
    }
}
