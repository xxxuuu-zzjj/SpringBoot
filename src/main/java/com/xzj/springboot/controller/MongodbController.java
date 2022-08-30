package com.xzj.springboot.controller;

import com.xzj.springboot.entity.Animal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "02 mongoDB 测试")
@RestController
@RequestMapping("/mongodb")
public class MongodbController {

    @Resource
    private MongoTemplate mongoTemplate;

    @ApiOperation("mongodb 插入数值")
    @PostMapping("insert")
    public void insert(){
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setCarName("tank_one");
        animal.setPrice(21423.342);
        mongoTemplate.insert(animal);
    }
}
