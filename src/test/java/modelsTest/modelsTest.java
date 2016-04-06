package modelsTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sovas.models.Drink;
import org.sovas.models.Lunch;
import org.sovas.models.Order;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;

public class modelsTest {

    private Desert desert;
    private MainCourse mainCourse;
    private Drink drink;

    private Order order;


    @Before
    public void setUp() {
        desert = new Desert();
        mainCourse = new MainCourse();
        drink = new Drink();

        order = new Order();

        mainCourse.setPrice(40.0);
        desert.setPrice(10.0);
        drink.setPrice(20.0);

        order.setMainCourse(mainCourse);
        order.setDesert(desert);
        order.setDrink(drink);

    }

    @Test
    public void shouldCheckOrderFields() {

        Assert.assertNotNull(order.getMainCourse());
        Assert.assertNotNull(order.getDesert());
        Assert.assertNotNull(order.getDrink());

    }

    @Test
    public void shouldCalculateTotalPrice() {
        order.calcTotalPrice();
        Assert.assertEquals(70.0, order.getTotalPrice(), 0.0);
    }

}
