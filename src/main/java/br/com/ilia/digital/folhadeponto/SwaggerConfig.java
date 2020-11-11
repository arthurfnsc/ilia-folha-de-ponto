package br.com.ilia.digital.folhadeponto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.ilia.digital.folhadeponto"))
            .build()
            .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {

        String description = new String("");

        return new ApiInfoBuilder()
            .title("Folha de Ponto REST API")
            .description(description)
            .version("1.0.0")
            .build();
    }
}
