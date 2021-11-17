package com.example.docker_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author cwr  ## 1. 引入swagger是方便测试
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 设置swagger跨域，提供给service调用
     * @return
     */
    @Bean
    public WebMvcConfigurer crossConfigurer(){
        WebMvcConfigurer webMvcConfigurerAdapter = new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/v2/api-docs");
                registry.addMapping("/**");
            }
        };
        return webMvcConfigurerAdapter;
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //基础扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.docker_demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("java")
                .description("java项目打包成docker images并运行")
                .version("1.0.0")
                .build();
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 2允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 3允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}

