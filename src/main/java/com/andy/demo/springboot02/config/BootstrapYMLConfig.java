/**
 * Copyright (C), 2015-2018
 * FileName: BootstrapConfig
 * Author:   59458
 * Date:     2018/6/4 22:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.andy.demo.springboot02.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * 〈一句话功能简述〉<br>
 * 〈加载 自定义的Yml属性文件，重点〉
 *
 * @author 59458
 * @create 2018/6/4
 * @since 1.0.0
 */
@Configuration
public class BootstrapYMLConfig {
    /**
     * 加载 自定义的 YML属性文件
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yams = new YamlPropertiesFactoryBean();
        // 源码：Resource... resources ；支持加载多个资源文件
        yams.setResources(new ClassPathResource("ftp.yml"), new ClassPathResource("complex.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yams.getObject());
        return propertySourcesPlaceholderConfigurer;
    }
}