package org.sovas;

import org.sovas.services.RestaurantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationStarter {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(ApplicationStarter.class, args);

        RestaurantService restaurantService = ctx.getBean(RestaurantService.class);

        restaurantService.setUpDatabase();
        restaurantService.printDatabase();
        restaurantService.doOrder();

    }

}

