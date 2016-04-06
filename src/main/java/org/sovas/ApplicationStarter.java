package org.sovas;

import org.sovas.models.Drink;
import org.sovas.models.Lunch;
import org.sovas.models.Order;
import org.sovas.models.cuisine.Cuisine;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;
import org.sovas.services.RestaurantService;
import org.sovas.services.dao.drinkDao.DrinkDaoImpl;
import org.sovas.services.dao.lunchDao.LunchDaoImpl;
import org.sovas.services.dao.lunchParts.desertDao.DesertDaoImpl;
import org.sovas.services.dao.lunchParts.mainCourseDao.MainCourseDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ApplicationStarter extends RestaurantService {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ApplicationStarter.class, args);

        // dao beans
        LunchDaoImpl lunchDaoBean = ctx.getBean(LunchDaoImpl.class);
        DrinkDaoImpl drinkDaoBean = ctx.getBean(DrinkDaoImpl.class);
        MainCourseDaoImpl mainCourseDaoBean = ctx.getBean(MainCourseDaoImpl.class);
        DesertDaoImpl desertDaoBean = ctx.getBean(DesertDaoImpl.class);


        // initialize MENU
        List<Lunch> lunches = lunchDaoBean.getAll();
        List<Drink> drinks = drinkDaoBean.getAll();
        List<MainCourse> mainCourses = mainCourseDaoBean.getAll();
        List<Desert> deserts = desertDaoBean.getAll();


        printDatabase(lunches, drinks, mainCourses, deserts);

        Order order = new Order();

        System.out.println("Hello Customer! How can I help you?");
        System.out.println("1. Order");
        System.out.println("2. Quit");


        int choose = validator(1,2);

        if (choose == 2) {
            System.out.println("Have a nice day!");
            return;
        }

        if (choose == 1) {
            System.out.println("Pick cuisine");
            System.out.println("1. Polish");
            System.out.println("2. Mexican");
            System.out.println("3. Italian");

            choose = validator(1,3);

            if (choose == 1) {
                System.out.println("Polish Food! Yum!");
                System.out.println("Choose LUNCH. There are our Polish LUNCH sets");
                orderLunch(lunches, Cuisine.POLISH, mainCourses, deserts, order);
                orderDrink(drinks,order);
            }
            if (choose == 2) {
                System.out.println("Mexican Food! Spicy!");
                System.out.println("Choose LUNCH. There are our Mexican LUNCH sets");
                orderLunch(lunches, Cuisine.MEXICAN, mainCourses, deserts, order);
                orderDrink(drinks,order);
            }
            if (choose == 3) {
                System.out.println("Italian Food! Delizioso!");
                System.out.println("Choose LUNCH. There are our Italian LUNCH sets");
                orderLunch(lunches, Cuisine.ITALIAN, mainCourses, deserts, order);
                orderDrink(drinks,order);
            }
        }

        order.calcTotalPrice();

        System.out.println("\nDEBUG: Your Order = " + order.toString() + "\n");

        System.out.println("Total cost = " + order.getTotalPrice());
        System.out.println("Enjoy your meal!\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");


    }


}

