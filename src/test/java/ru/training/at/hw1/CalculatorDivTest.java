package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorDivTest {
    Calculator calculator = null;

    @BeforeTest(groups = {Tags.MULT_DIV})
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {Tags.MULT_DIV},
            dataProvider = DataProviders.DIV_LONG_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteDivOperationsWithLong(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.MULT_DIV},
            dataProvider = DataProviders.DIV_DOUBLE_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteDivOperationsWithDouble(double a, double b,
                                                            double expected, double accuracy) {
        double actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected, accuracy);
    }

    @Test(groups = {Tags.MULT_DIV},
            dataProvider = DataProviders.DIV_BY_ZERO_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class,
            expectedExceptions = NumberFormatException.class)
    public void calculatorCanOperateWithDivisionByZero(long a, long b) {
        calculator.div(a, b);
    }
}
