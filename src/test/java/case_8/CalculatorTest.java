package case_8;

import case_1.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CalculatorTest {
    @DataProvider
    public static Object[][] Division() {
       Object[][] result = new Object[3][3];
       result[0][0] = 1; result[0][1] = 1; result[0][2] = 1;
        result[1][0] = 5; result[1][1] = 2; result[1][2] = 2.5;
        result[2][0] = -30; result[2][1] = -10; result[2][2] = 3;
        return result;
    }

    @Test
    void AdditionTest() {
        assertEquals(Calculator.plus(5, 5), 10, "Wrong Addition");
    }
    @Test
    void SubtractionTest() {
        assertEquals(Calculator.minus(4, 5), -1, "Wrong Subtraction");
    }
    @Test
    void MultiplicationTest(){
        assertEquals(Calculator.times(5, 5), 25, "Wrong Multiplication");
    }
    @Test(dataProvider = "Division")
    void DivisionTest(double a ,double b,double expected){
        assertEquals(Calculator.dividedBy(a,b),expected,"Wrong Division");
    }
}
