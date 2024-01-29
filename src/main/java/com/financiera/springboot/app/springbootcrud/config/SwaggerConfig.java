package pe.financieraoh.business.bstrfinmediatasbatch.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("proyect")
        		.apiInfo(apiInfo())
                .select()
				.paths(regex("/v.*"))
                .build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API REST CRUD")
				.description("APIR CRUD")
				.termsOfServiceUrl("Terminos de Servicio")
				.license("Financiera Oh!")
				.version("1.0")
				.build();
	}
}
