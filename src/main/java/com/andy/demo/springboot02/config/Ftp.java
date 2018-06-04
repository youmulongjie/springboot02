/**
 * Copyright (C), 2015-2018
 * FileName: Ftp
 * Author:   59458
 * Date:     2018/6/2 22:24
 * Description: Ftp 配置文件 Bean
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.andy.demo.springboot02.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈Ftp 配置文件 Bean〉
 *
 * @author 59458
 * @create 2018/6/2
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "ftp")
@Data
public class Ftp {

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
    * 测试中文
    */
    public String chinese;
}