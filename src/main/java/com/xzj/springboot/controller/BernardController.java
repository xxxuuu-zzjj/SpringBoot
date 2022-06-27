package com.xzj.springboot.controller;

import com.xzj.springboot.annotation.NotControllerResponseAdvice;
import com.xzj.springboot.common.exception.APIException;
import com.xzj.springboot.common.exception.AppCode;
import com.xzj.springboot.common.response.Response;
import com.xzj.springboot.dao.StudentDao;
import com.xzj.springboot.entity.Product;
import com.xzj.springboot.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @RestController = @Controller + ResponseBody
 *             所有返回的参数放到 ResponseBody
 */
@Api(tags = {"01 封装返回类"})
@RestController
@RequestMapping("/xu")
public class BernardController {

    @Resource
    StudentDao studentDao;

    @GetMapping("getName")
    @NotControllerResponseAdvice
    public String getName(){
        return "123";
    }

    @ApiOperation("校验")
    @PostMapping("product")
    public Response addProduct(@RequestBody @Validated Product vo){
        if (vo.getProductName().equals("da ma")){
            throw new APIException(AppCode.APP_ERROR,"禁售产品");
        }
        System.out.println(vo);
        return new Response();
    }

    @ApiOperation("添加学生")
    @PostMapping("addStudent")
    @Transactional(rollbackFor=Exception.class)
    public void add(){
        Student student = new Student();
        student.setName("san san");
        studentDao.addStudent(student);
    }

    @ApiOperation("修改学生信息")
    @PostMapping("updateStudent")
    @Transactional(rollbackFor = Exception.class)
    public void update(){
        Student student = new Student();
        student.setName("zzzz");
        student.setId(1L);
        studentDao.updateStudent(student);
    }
}
