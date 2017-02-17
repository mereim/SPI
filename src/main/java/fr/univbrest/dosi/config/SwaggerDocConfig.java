package fr.univbrest.dosi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("API SPI")
            .description("Swagger permettant de décrire et tester l'API REST Spi.")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("ToS")
            .version("1.0")
            .contact(new Contact("Api Developpeur","", ""))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("fr.univbrest.dosi.controllers"))
                    .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }
    
}
