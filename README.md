springboot02 学习
================================
springboot 版本：2.0.2.RELEASE

## 引入maven依赖
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```
## 加载自定义 properties 属性文件
- @Configuration 开启配置注解
- @PropertySource 指定属性文件地址，并设置编码（该注解只能加载*.properties 属性文件，不支持YML属性文件）
- @ConfigurationProperties 设置属性的前缀
- @Data 这是 lombok 插件的注解（很好用，需要下载lombok插件，并引入maven依赖），相当于 set\get 访问器、toString()、equals()等
```java
@Configuration 
@PropertySource(value = "classpath:ftp.properties", encoding = "utf-8")
@ConfigurationProperties(prefix = "com.andy.ftp")
@Data
public class FtpProperties {
    // 定义属性（和属性文件key保持一直） ...
}
```
## 加载自定义 YML 属性文件
- Bean配置去掉@PropertySource，其余同上（默认的@PropertySource 不支持加载 YML文件，继承 DefaultPropertySourceFactory 类，重写createPropertySource()可以实现，本例没有采取这种方法）
- 本例实现加载YML文件，在于 BootstrapYMLConfig.java 类
```java
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
```
- YML 可以实现复杂的配置，比如 Map、List、List<Map>等类型，如complex.yml
```yaml
# 复杂的 YML 配置文件
complex:
  name: Andy         # String
  luckNum: 3,7,11,16 # Array
  fullNameMapList:   # List Map
    - name: 李
      value: 清照
    - name: 王
      value: 勃
    - name: 杜甫
      value: 甫
  henanCityList:      # List
    - 河南
    - 平顶山
    - 汝州
    - 小屯
    - 李湾
  workplaceMap:       # Map
    1: 远卓
    2: 长虹佳华
```
## Andy.wang

<img src="doc/594580820.jpg" width="15%" alt="Andy.wang的QQ"/>