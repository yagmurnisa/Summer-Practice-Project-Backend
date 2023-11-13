package tech.reaven.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApiConfig(){
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo(){
        Info info = new Info();
        info.title("Instrument Statistics API")
                .description("Instrument Statistics API Demo")
                .version("v1.0.0");
        return info;
    }
}
