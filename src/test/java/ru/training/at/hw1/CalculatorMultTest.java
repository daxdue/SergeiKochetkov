package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorMultTest {
    Calculator calculator = null;

    @BeforeTest(groups = {Tags.MULT_DIV})
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {Tags.MULT_DIV},
            dataProvider = TestsDataProvider.MUL_LONG_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteMulOperationsWithLongArgs(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.MULT_DIV},
            dataProvider = TestsDataProvider.MUL_DOUBLE_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteMulOperationsWithDouble(double a, double b,
                                                            double expected, double accuracy) {
        double actual = calculator.mult(a, b);
        Assert.assertEquals(actual, expected, accuracy);
    }
}
