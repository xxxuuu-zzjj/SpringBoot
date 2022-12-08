package com.xzj.springboot;

import com.xzj.springboot.common.exception.AppCode;
import com.xzj.springboot.dao.StudentDao;
import com.xzj.springboot.entity.Animal;
import com.xzj.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
class ApplicationTests {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void contextLoads() {
        Animal animal = new Animal();
        animal.setId(5L);
        animal.setCarName("tank_one");
        animal.setPrice(21423.342);
        mongoTemplate.insert(animal);
        System.out.println(10/0);
    }

    @Resource public StudentDao studentDao;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void mysqlTransactional(){
        Student student = new Student();
        student.setName("zg");
        studentDao.addStudent(student);
        System.out.println(10/0);
    }
    
    @Test
    public void copy(){
        Animal animal1 = new Animal();
        animal1.setId(5L);
        animal1.setCarName("tank_one");
        animal1.setPrice(21423.342);

        Animal animal2 = new Animal();
        animal2.setCarName("sanMu");

        Animal cat = new Animal();
        BeanUtils.copyProperties(animal1, cat);
        BeanUtils.copyProperties(animal2, cat);
        System.out.println(cat);
    }

    @Test
    public void outError(){
        System.out.println(AppCode.APP_ERROR);
    }

}
