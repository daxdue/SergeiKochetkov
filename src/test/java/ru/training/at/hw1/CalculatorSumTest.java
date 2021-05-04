package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorSumTest {
    Calculator calculator = null;

    @BeforeTest(groups = {Tags.ADD_SUB})
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(groups = {Tags.ADD_SUB},
            dataProvider = DataProviders.SUM_LONG_DATA_PROVIDER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteSumOperationsWithLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.ADD_SUB},
            dataProvider = DataProviders.SUM_DOUBLE_DATA_PROVER,
            dataProviderClass = TestsDataProvider.class)
    public void calculatorCanExecuteSumOperationsWithDouble(double a, double b,
                                                            double expected, double accuracy) {
        double actual = calculator.sum(a, b);
        Assert.assertEquals(actual, expected, accuracy);
    }
}
