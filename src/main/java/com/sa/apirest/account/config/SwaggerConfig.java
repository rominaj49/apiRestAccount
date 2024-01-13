package com.sa.apirest.account.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@OpenAPIDefinition
@Configuration

public class SwaggerConfig {
        @Bean
    public OpenAPI getApiInfo() {
    
        ApiResponse okAPI = new ApiResponse().content(
            new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE, 
                    new io.swagger.v3.oas.models.media.MediaType().addExamples("default",
                            new Example().value("{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" : \"Traido con exito!\"}")))
        );
        
        Components components = new Components();
        components.addResponses("okAPI", okAPI);
        
        
        return new OpenAPI()
                            .components(components)
                            .info(new Info().title("MS Basico")
                            .version("v1")
                            .description("Manejo de cuentas")
                            .termsOfService("http://www.sistemasactivos.com/terminos")
                            .contact(new Contact()
                            .name("RJ")
                            .email("asd@gmail.com")
                            .url("http://www.sistemasactivos.com"))
                );
        
    }
    
   

}
