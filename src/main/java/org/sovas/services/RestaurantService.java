package org.sovas.services;

import lombok.Data;
import org.sovas.models.Drink;
import org.sovas.models.Lunch;
import org.sovas.models.Order;
import org.sovas.models.cuisine.Cuisine;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;
import org.sovas.services.dao.drinkDao.DrinkDaoImpl;
import org.sovas.services.dao.lunchDao.LunchDaoImpl;
import org.sovas.services.dao.lunchParts.desertDao.DesertDaoImpl;
import org.sovas.services.dao.lunchParts.mainCourseDao.MainCourseDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class RestaurantService {

    // dao beans
    @Autowired
    private LunchDaoImpl lunchDaoBean;

    @Autowired
    private DrinkDaoImpl drinkDaoBean;

    @Autowired
    private MainCourseDaoImpl mainCourseDaoBean;

    @Autowired
    private DesertDaoImpl desertDaoBean;

    // database
    private List<Lunch> lunches;
    private List<Drink> drinks;
    private List<MainCourse> mainCourses;
    private List<Desert> deserts;

    static Order order = new Order();

    public void setUpDatabase() {
        lunches = lunchDaoBean.getAll();
        drinks = drinkDaoBean.getAll();
        mainCourses = mainCourseDaoBean.getAll();
        deserts = desertDaoBean.getAll();
    }


    public void doOrder() {
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

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Total cost = " + order.getTotalPrice() + "PLN");
        System.out.println("Enjoy your meal!\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("\nClosing...\n");
    }

    private int validator(int min, int max) {

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


    private void orderDrink(List<Drink> drinks, Order order) {

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
                System.out.print(drink.getName() + " - " + drink.getPrice() + "PLN\n");
                max++;
            }

            choose = validator(1, max);
            order.setDrink(drinks.get(choose - 1));

        }
        if(choose==2){
            System.out.println("As you wish");
        }

    }


    private void orderLunch(List<Lunch> lunches, Cuisine cuisine, List<MainCourse> mainCourses, List<Desert> deserts, Order order) {

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
                System.out.print(", Main Course: " + mainCourse.getName() + " - " + mainCourse.getPrice() + "PLN");
                System.out.print(", Desert: " + desert.getName() + " - " + desert.getPrice() + "PLN" + "\n");

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



    public void printDatabase() {

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
