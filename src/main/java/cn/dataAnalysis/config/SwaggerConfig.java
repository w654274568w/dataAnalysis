package cn.dataAnalysis.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hxf
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
//        Contact contact = new Contact(" 晓峰 ", "", "654274568@qq.com");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("DataAnalysis(房产数据分析 中台) APIs")
                .useDefaultResponseMessages(false)
                .apiInfo(new ApiInfoBuilder()
                        .title("房产数据分析 中台")
                        .description("房产数据分析 中台接口文档")
                        .version("0.0.1")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.dataAnalysis.apiController"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

}
