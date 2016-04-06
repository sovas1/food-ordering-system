package org.sovas.services;

import org.sovas.models.Drink;
import org.sovas.models.Lunch;
import org.sovas.models.Order;
import org.sovas.models.cuisine.Cuisine;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;

import java.util.*;

public class RestaurantService {


    protected static int validator(int min, int max) {

        Scanner scanner = new Scanner(System.in);

        int choose = 0;
        boolean valid = false;

        while (!valid) {
            try {
                choose = scanner.nextInt();
                if(choose >= min && choose <= max) {
                    valid = true;
                }
                else {
                    System.out.println("Wrong number.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong format.");
                scanner.next();
            }
        }
        return choose;

    }


    protected static void orderDrink(List<Drink> drinks, Order order) {

        // -1 in get() methods due to difference between entity id and List<> indexing

        System.out.println("You look thirsty! Maybe something to drink?");

        System.out.println("1. Yes");
        System.out.println("2. No");

        int choose = validator(1,2);

        if(choose==1){

            int max = 0;
            System.out.println("Here are our drinks:");

            for (Drink drink : drinks) {
                System.out.print(drink.getDrinkId() + ". ");
                System.out.print(drink.getName() + " - " + drink.getPrice() + "€\n");
                max++;
            }

            choose = validator(1, max);
            order.setDrink(drinks.get(choose - 1));

        }
        if(choose==2){
            System.out.println("As you wish");
        }

    }


    protected static void orderLunch(List<Lunch> lunches, Cuisine cuisine, List<MainCourse> mainCourses, List<Desert> deserts, Order order) {

        // -1 in get() methods due to difference between entity id and List<> indexing

        int count = 1;

        MainCourse mainCourse;
        Desert desert;

        Map<Integer,Lunch> lunchLongMap = new HashMap<>();

        for (Lunch lunch : lunches) {

            if (lunch.getCuisine() == cuisine) {

                mainCourse = mainCourses.get(Math.toIntExact(lunch.getMainCourseId()) - 1);
                desert = deserts.get(Math.toIntExact(lunch.getDesertId()) - 1);

                // PUT NUMBER + CORRESPONDING LUNCH to MAP for future ORDER assignment
                lunchLongMap.put(count,lunch);

                System.out.print(count + ". ");
                System.out.print("Set name: " + lunch.getName());
                System.out.print(", Main Course: " + mainCourse.getName() + " - " + mainCourse.getPrice() + "€");
                System.out.print(", Desert: " + desert.getName() + " - " + desert.getPrice() + "€" + "\n");

                count++;
            }

        }


        int choose = validator(1, count - 1);

        Lunch yourLunch = lunchLongMap.get(choose);

        MainCourse yourMainCourse = mainCourses.get(Math.toIntExact(yourLunch.getMainCourseId()) - 1);
        Desert yourDesert = deserts.get(Math.toIntExact(yourLunch.getDesertId()) - 1);

        order.setMainCourse(yourMainCourse);
        order.setDesert(yourDesert);

    }



    protected static void printDatabase(List<Lunch> lunches, List<Drink> drinks, List<MainCourse> mainCourses, List<Desert> deserts) {

        System.out.println("\n~~~~ DATABASE PRINTING ~~~~\n");

        System.out.println("Lunches: ");
        for (Lunch lunch : lunches) {
            System.out.println(lunch.toString());
        }

        System.out.println("Drinks: ");
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }

        System.out.println("Main Courses: ");
        for (MainCourse mc : mainCourses) {
            System.out.println(mc.toString());
        }

        System.out.println("Deserts: ");
        for (Desert desert : deserts) {
            System.out.println(desert.toString());
        }

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~\n");

    }

}
