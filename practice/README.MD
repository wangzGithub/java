# 在项目中加入swagger2
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
```
# 引入swagger2界面美化
```
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>1.9.6</version>
</dependency>
```
# 增加swagger2配置文件
```
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ego.practice.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTFUL APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:8080")
                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }
}
```
# 项目运行后打开http://{ip}:{port}/doc.html查看接口文档
# 分别在类和方法上使用注解@Api(tags = {"测试接口"})@ApiOperation(value = "返回name")来管理接口文档的接口说明