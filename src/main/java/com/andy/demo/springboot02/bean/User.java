/**
 * Copyright (C), 2015-2018
 * FileName: User
 * Author:   59458
 * Date:     2018/6/2 21:30
 * Description: 用户实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.andy.demo.springboot02.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户实体类〉
 *
 * @author 59458
 * @create 2018/6/2
 * @since 1.0.0
 */
@Data
@Builder
public class User {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    // 接送、串中不展示该属性
    @JsonIgnore
    private String userPwd;

    /**
     * 生日
     */
    // 日期格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    /**
     * 简介
     */
    // 为空时，json串中不展示该属性
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;
}