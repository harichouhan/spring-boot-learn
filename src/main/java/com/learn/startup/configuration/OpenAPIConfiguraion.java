package com.learn.startup.configuration;


import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Learn with Hari!!", version = "1.0", description = "Keep Going!!!"))
@SecurityScheme(
	    name = "bearer-key",
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    scheme = "bearer"
	)
public class OpenAPIConfiguraion {
	
	
	// Can be done either by the @SecurityScheme or by below code.
	
//	@Bean
//	 public OpenAPI customOpenAPI() {
//	   return new OpenAPI()
//	          .components(new Components()
//	          .addSecuritySchemes("bearer-key",
//	          new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
//	}

}
