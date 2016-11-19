package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
//@ComponentScan(basePackages = {"com.figer.Main"})
public class SwaggerConfiguration {
  @Bean
  public Docket categoryApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("all").pathProvider(new AbstractPathProvider() {
      protected String applicationPath() {
        return "/";
      }

      protected String getDocumentationPath() {
        return "/";
      }
    }).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("").build();
  }
}

