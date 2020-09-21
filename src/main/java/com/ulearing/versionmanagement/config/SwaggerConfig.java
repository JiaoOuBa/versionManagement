package com.ulearing.versionmanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.common.SwaggerPluginSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2配置
 * @Desc
 * @Author chenkun
 * @Date 2020-09-17 13:36
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${version.swagger.open}")
    private boolean openSwagger;

    @Bean
    public Docket adminApi() {

        List<Parameter> param = new ArrayList<>();

        // token验证header
        ParameterBuilder commonTicketPar = new ParameterBuilder();
        commonTicketPar.name("Authorization")
                .description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER - 1)
                .required(false).build();
        param.add(commonTicketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理api接口文档")
                .enable(openSwagger)
                .apiInfo(apiInfo("version管理接口文档(Api)"))
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com"))// 对所有api进行监控
                .paths(PathSelectors.any())
                .build().globalOperationParameters(param);
    }

    private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                .title("version Api")
                .contact(new Contact("ck","#","xxxx@example.com"))
                .version("0.0.1")
                .description(desc)
                .build();
    }
}
