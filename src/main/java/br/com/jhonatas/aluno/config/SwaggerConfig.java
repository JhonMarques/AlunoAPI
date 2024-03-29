package br.com.jhonatas.aluno.config;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket alunoAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.jhonatas.aluno"))
            .paths(PathSelectors.regex("/aluno.*"))
            .build()
            .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "Bookstore API REST",
            "API REST de cadastro de Livros e suas respectivas categorias.",
            "1.0",
            "Terms of Service",
            new Contact(
                "Jhonatas Katayama Marques",
                "Fone: (18)99680-1054",
                "jhonataskm@gmail.com"
            ),
            "Apache License Version 2.0",
            "https://www.apache.org/licensen.html",
            new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
