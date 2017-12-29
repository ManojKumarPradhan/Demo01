package com.bigob;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bigob.controller"))
				.paths(PathSelectors.regex("/doctor.*")).build().apiInfo(ownApi());
	}

	private ApiInfo ownApi() {
		return new ApiInfo("Doctor Details", "Information Of Doctor with Endpiont", "1.0.0", "No Terms Yet",
				new Contact("Manoj Kumar Pradhan", "No Url I Have", "manojbibhupradhan@gmail.com"),
				"Some Licience Version", "haha");
	}
}
