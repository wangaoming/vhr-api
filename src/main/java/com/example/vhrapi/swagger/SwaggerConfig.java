package com.example.vhrapi.swagger;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Data
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.vhrapi.controller"))
                .paths(PathSelectors.any())
                .build();
    }
//   基本信息配置，会在api文档中显示

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("微人事测试接口文档")//标题
                .description("微人事相关接口文档")//描述
                .termsOfServiceUrl("http://localhost:8080")//服务说明url
                .contact(new Contact("niit","http://www.niit.com","admin@niit.com"))//作者联系方式
                .version("1.0")//版本号
                .build();
    }
}
