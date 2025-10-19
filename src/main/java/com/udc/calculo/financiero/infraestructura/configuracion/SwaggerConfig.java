package com.udc.calculo.financiero.infraestructura.configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
    	//sin seguridad jwt
         return new OpenAPI()
            .info(new Info()
                    .title("API de Cálculo de Aportes Parafiscales")
                    .version("1.0.0")
                    .description("Servicio REST para el cálculo de aportes de salud, pensión y ARL")
                    .contact(new Contact()
                            .name("Equipo UDC Finanzas")
                            .email("soporte@udcfinanzas.com"))
                    .license(new License()
                            .name("Apache 2.0")
                            .url("http://springdoc.org")));
//    			con seguridad jwt
//		        return new OpenAPI()
//		                .info(new Info()
//		                        .title("API de Cálculo de Aportes Parafiscales")
//		                        .version("1.0.0")
//		                        .description("Servicio REST para el cálculo de aportes de salud, pensión y ARL")
//		                        .contact(new Contact()
//		                                .name("Equipo UDC Finanzas")
//		                                .email("soporte@udcfinanzas.com"))
//		                        .license(new License()
//		                                .name("Apache 2.0")
//		                                .url("http://springdoc.org")))
//		        // Define el esquema de seguridad Bearer
//		        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//		        .components(new io.swagger.v3.oas.models.Components()
//		                .addSecuritySchemes("bearerAuth",
//		                        new SecurityScheme()
//		                                .name("bearerAuth")
//		                                .type(SecurityScheme.Type.HTTP)
//		                                .scheme("bearer")
//		                                .bearerFormat("JWT")));
    }
}