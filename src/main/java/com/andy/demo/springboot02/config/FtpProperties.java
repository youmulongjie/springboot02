/**
 * Copyright (C), 2015-2018
 * FileName: FtpProperties
 * Author:   59458
 * Date:     2018/6/3 20:44
 * Description: Ftp属性文件配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.andy.demo.springboot02.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 〈一句话功能简述〉<br>
 * 〈Ftp属性文件配置类〉
 *
 * @author 59458
 * @create 2018/6/3
 * @since 1.0.0
 */
@Configuration // 开启配置注解
// 属性文件地址，编码 // @PropertySource注解只可以加载properties文件,无法加载yam文件
@PropertySource(value = "classpath:ftp.properties", encoding = "utf-8")
@ConfigurationProperties(prefix = "com.andy.ftp")
@Data
public class FtpProperties {
    /**
     * URL地址
     */
    private String url;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 测试中文 （需在 @PropertySource 中 设置 encoding = "utf-8"）
     */
    private String chinese;
}