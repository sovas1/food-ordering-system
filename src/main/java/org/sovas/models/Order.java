package org.sovas.models;

import lombok.Data;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;
import org.springframework.stereotype.Service;

@Service
@Data
public class Order {

    MainCourse mainCourse;
    Desert desert;

    Drink drink;
    double iceCubesPrice;
    double lemonPrice;


    double totalPrice;

    public void calcTotalPrice() {

        totalPrice += iceCubesPrice + lemonPrice;

        try {
            totalPrice += drink.getPrice();
        } catch (NullPointerException npe) {
            npe.getMessage();
            System.out.println("You didn't order any DRINK so I will not add any costs for that");
        }

        try {
            totalPrice += mainCourse.getPrice();
        } catch (NullPointerException npe) {
            npe.getMessage();
            System.out.println("You didn't order any MAIN COURSE so I will not add any costs for that");
        }

        try {
            totalPrice += desert.getPrice();
        } catch (NullPointerException npe) {
            npe.getMessage();
            System.out.println("You didn't order any DESERT so I will not add any costs for that");
        }
    }

}
