package org.sovas.services;

import org.sovas.models.Drink;
import org.sovas.models.Lunch;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;
import org.sovas.repositories.DesertRepository;
import org.sovas.repositories.DrinkRepository;
import org.sovas.repositories.LunchRepository;
import org.sovas.repositories.MainCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {

        System.out.println("\nDrinks");
        for (Drink drink : drinkRepository.findAll()) {
            System.out.println(drink.toString());
        }

        System.out.println("\nMain Courses");
        for (MainCourse mainCourse : mainCourseRepository.findAll()) {
            System.out.println(mainCourse.toString());
        }

        System.out.println("\nDeserts");
        for (Desert desert : desertRepository.findAll()) {
            System.out.println(desert.toString());
        }

        System.out.println("\nLunches");
        for (Lunch lunch : lunchRepository.findAll()) {
            System.out.println(lunch.toString());
        }

    }

    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    MainCourseRepository mainCourseRepository;

    @Autowired
    DesertRepository desertRepository;

    @Autowired
    LunchRepository lunchRepository;
}
