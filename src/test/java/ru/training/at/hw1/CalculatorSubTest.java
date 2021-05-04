package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorSubTest {
    Calculator calculator = null;

    @BeforeTest(groups = {Tags.ADD_SUB})
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {Tags.ADD_SUB},
            dataProvider = DataProviders.SUB_LONG_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteSubOperationsWithLongArguments(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.ADD_SUB},
            dataProvider = DataProviders.SUB_DOUBLE_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteSubOperationsWithDouble(double a, double b,
                                                            double expected, double accuracy) {
        double actual = calculator.sub(a, b);
        Assert.assertEquals(actual, expected, accuracy);
    }
}
