/**
 * Copyright (C), 2015-2018
 * FileName: Complex
 * Author:   59458
 * Date:     2018/6/4 23:09
 * Description: 复杂的 YML 对应的配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.andy.demo.springboot02.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈复杂的 YML 对应的配置类〉
 *
 * @author 59458
 * @create 2018/6/4
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "complex")
@Data
public class Complex {
    public String name;
    public List<Integer> luckNum;
    public List<Map<String, String>> fullNameMapList;
    public List<String> henanCityList;
    public Map<Integer, String> workplaceMap;
}