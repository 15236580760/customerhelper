package com.sun.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/298:45
 */
@Configuration
@EnableSwagger2
/**
 * Swagger文档接口的配置类
 */
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sun.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("王者荣耀计算器")
                        .description("计算器接口文档")
                        .version("1.0")
                      //  .contact(new Contact("","blog.csdn.net","aaa@gmail.com"))
                      //  .license("The Apache License")
                      //  .licenseUrl("http://www.baidu.com")
                        .build());
    }
}
