package tech.reaven.application;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.reaven.controller.StockController;
import tech.reaven.config.SwaggerConfig;
import tech.reaven.service.StockService;
import tech.reaven.repository.StockRepository;
import tech.reaven.controller.NewsController;
import tech.reaven.service.NewsService;
import tech.reaven.repository.NewsRepository;

@EnableJpaRepositories(basePackages = {"tech.reaven.repository"})
@EntityScan("tech.reaven.model")
@ComponentScan(basePackageClasses = {
        StockController.class, NewsController.class,
        StockService.class, NewsService.class,
        StockRepository.class, NewsRepository.class,
        SwaggerConfig.class
})
@SpringBootApplication
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class);
    }

}
