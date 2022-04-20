package case_8;

import case_1.Calculator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParamTest {
    @Parameters({ "param1","param2","param3" })
    @Test
    void AdditionParamTest(double a,double b, double expected) {
        assertEquals(Calculator.plus(a, b), expected, "Wrong Addition");
    }
}
