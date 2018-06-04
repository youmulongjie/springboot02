/**
 * Copyright (C), 2015-2018
 * FileName: TestJsonController
 * Author:   59458
 * Date:     2018/6/2 21:40
 * Description: 测试 fasterxml 注解的Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.andy.demo.springboot02.controller;

import com.andy.demo.springboot02.bean.User;
import com.andy.demo.springboot02.config.Complex;
import com.andy.demo.springboot02.config.Ftp;
import com.andy.demo.springboot02.config.FtpProperties;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 59458
 * @create 2018/6/2
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private Ftp ftp;

    @Autowired
    private FtpProperties ftpProperties;

    @Autowired
    private Complex complex;

    /**
     * 测试 desc 属性不为空，返回的json串中包含该属性
     *
     * @return
     */
    @GetMapping(value = "/user1")
    public User getUser() {
        return User.builder().id(1L).userName("Andy.wang").userPwd("123456").birthday(new Date()).desc("第一个用户").build();
    }

    /**
     * 测试 desc 属性为空，返回的json串中不包含该属性
     *
     * @return
     */
    @GetMapping(value = "/user2")
    public User getUser2() {
        return User.builder().id(2L).userName("王先生").userPwd("123456").birthday(new Date()).build();
    }

    /**
     * 测试 自定义属性文件（properties 文件）注入
     * (注意事项：不知道为什么 直接返回 ftpProperties，在jackson转json串时一直报异常，因此使用 copy对象)
     *
     * @return
     */
    @GetMapping(value = "/ftpProperties")
    public FtpProperties getFtpProperties() {
        FtpProperties target = new FtpProperties();
        BeanUtils.copyProperties(ftpProperties, target);
        return target;
    }

    /**
     * 测试 自定义属性文件（yml 文件）注入
     *
     * @return
     */
    @GetMapping(value = "/ftp")
    public Ftp ftp() {
        return ftp;
    }

    /**
     * 测试 复杂的YML 注入
     *
     * @return
     */
    @GetMapping(value = "complex")
    public Complex complex() {
        return complex;
    }

}