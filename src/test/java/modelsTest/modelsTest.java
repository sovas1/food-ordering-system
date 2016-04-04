package modelsTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sovas.models.Lunch;
import org.sovas.models.lunchParts.Desert;
import org.sovas.models.lunchParts.MainCourse;

public class modelsTest {

    Desert desert;
    MainCourse mainCourse;
    Lunch lunch;

    @Before
    public void setUp() {
        desert = new Desert();
        mainCourse = new MainCourse();
        lunch = new Lunch();
    }

    @Test
    public void shouldInitializeLunch() {
        lunch.setMainCourse(mainCourse);
        lunch.setDesert(desert);

        Assert.assertNotNull(lunch.getMainCourse());
        Assert.assertNotNull(lunch.getDesert());
    }

}
