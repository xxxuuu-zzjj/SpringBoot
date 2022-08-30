package com.xzj.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "animal")
public class Animal {

    @Id private Long id;

    private String carName;

    private Double price;

    private Date createTime;

    private Date updateTime;
}
