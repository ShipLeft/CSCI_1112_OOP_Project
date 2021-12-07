import static org.junit.Assert.*;
import org.junit.Test;

public class CalorieCounterTest {

    @Test
    public void test(){
        Food foodTest = new Food();

        foodTest.setCalories(123);
        foodTest.setProtein(124);
        foodTest.setFat(125);
        foodTest.setCarbs(126);
        foodTest.setSodium(127);
        foodTest.setAgain(245);

        String getStringTest = foodTest.getString();
        String getStringExpected = "\nTotal amounts for the meal:\nCalories: 123" +
                "\nProtein: 124\nFats: 125\nCarbs: 126\nSodium: 127";
        assertEquals(getStringExpected, getStringTest);

        String myStringTest = foodTest.myString();
        String myStringExpected = "\nTotal amounts for day 245:\nCalories: 123"
                +"\nProtein: 124\nFats: 125\nCarbs: 126\nSodium: 127";
        assertEquals(myStringExpected, myStringTest);
    }

}