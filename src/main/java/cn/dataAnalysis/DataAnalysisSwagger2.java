package cn.dataAnalysis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 */
@Configuration
@EnableSwagger2
public class DataAnalysisSwagger2 {
    @Bean
    public Docket createRestApi() {

//        List<ResponseMessage> list = new ArrayList<>();
//        list.add(new ResponseMessageBuilder()
//                .code(500002)
//                .message("50002 message")
//                .responseModel(new ModelRef("Error"))
//                .build());
//        list.add(new ResponseMessageBuilder()
//                .code(40312)
//                .message("Forbidden!")
//                .build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.dataAnalysis.api"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);

//                        .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.POST, list)
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact(" 晓峰 ", "", "654274568@qq.com");
        ApiInfo apiInfo = new ApiInfo("DataAnalysis(房产数据分析 后台) APIs",//大标题
                "" +
                        "【使用说明】：" +
                        "普通调用使用 try catch，" +
                        "ajax调用使用error回调函数。</br>" +
                        "【业务异常返回值(JSON)】：" +
                        " status 业务异常状态码；" +
                        " error 标准异常信息；" +
                        " message 自定义异常信息；" +
                        " exception 异常类型；" +
                        " timestamp 时间戳。" +
                        "",//小标题
                "1.0",//版本
                "",
                contact,//作者
                "房产数据分析",//链接显示文字
                ""//网站链接
        );
        return apiInfo;

    }
}
