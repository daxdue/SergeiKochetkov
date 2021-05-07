package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class TestsDataProvider {

    public static final String SUM_LONG_DATA_PROVIDER = "sum_long_data_provider";
    public static final String SUM_DOUBLE_DATA_PROVER = "sum_double_data_provider";
    public static final String SUB_LONG_DATA_PROVIDER = "sub_long_data_provider";
    public static final String SUB_DOUBLE_DATA_PROVIDER = "sub_double_data_provider";
    public static final String MUL_LONG_DATA_PROVIDER = "mul_long_data_provider";
    public static final String MUL_DOUBLE_DATA_PROVIDER = "mul_double_data_provider";
    public static final String DIV_LONG_DATA_PROVIDER = "div_long_data_provider";
    public static final String DIV_DOUBLE_DATA_PROVIDER = "div_double_data_provider";
    public static final String DIV_BY_ZERO_DATA_PROVIDER = "div_by_zero_data_provider";

    @DataProvider(name = SUM_LONG_DATA_PROVIDER)
    public Object[][] longAddTestDataProvider() {
        return new Object[][] {{0, 0, 0}, {-1456, 1456, 0}, {-3953, -1264, -5217},
            {9_223_372_036_854_775_807L, 8, -9_223_372_036_854_775_801L},
            {-9_223_372_036_854_775_808L, -7, 9_223_372_036_854_775_801L}};
    }

    @DataProvider(name = SUM_DOUBLE_DATA_PROVER)
    public Object[][] doubleAddTestDataProvider() {
        return new Object[][] {{0.0, 0.0, 0.0, 0.1}, {77.34, 12, 89.34, 0.1},
            {-132.56, 13.43, -119.13, 0.1},
            {95632.323767, 1245.573721, 96877.897488, 0.0000001},
            {Double.MIN_VALUE, Double.MIN_VALUE, 0, 0.1},
            {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.1}};
    }

    @DataProvider(name = SUB_LONG_DATA_PROVIDER)
    public Object[][] longSubTestDataProvider() {
        return new Object[][] {{0, 0, 0}, {2366, 243, 2123},
            {-13, -13, 0}, {-674, 965, -1639}, {45, 45, 0},
            {-9_223_372_036_854_775_808L, -7, -9_223_372_036_854_775_801L},
            {9_223_372_036_854_775_807L, -9_223_372_036_854_775_801L, -8},
            {-9_223_372_036_854_775_808L, -9_223_372_036_854_775_808L, 0}};
    }

    @DataProvider(name = SUB_DOUBLE_DATA_PROVIDER)
    public Object[][] doubleSubDataProvider() {
        return new Object[][] {{0.0, 0.0, 0.0, 0.1}, {456.12, 54, 402.12, 0.001},
            {-5935.16892, -6719.3463, 784.17738, 0.00001},
            {0, 15.333333333, -15.333333333, 0.0000001},
            {Double.MIN_VALUE, Double.MIN_VALUE, 0, 0.1},
            {Double.MAX_VALUE, Double.MAX_VALUE, 0, 0.1}};
    }

    @DataProvider(name = MUL_LONG_DATA_PROVIDER)
    public Object[][] longMulTestDataProvider() {
        return new Object[][] {{0, 0, 0}, {2, 3, 6}, {143, 3, 429},
            {-12, 2, -24}, {-562, -98, 55076},
            {6512, -13, -84656}, {Long.MAX_VALUE, 0, 0}, {Long.MIN_VALUE, 0, 0},
            {Long.MAX_VALUE, 1, Long.MAX_VALUE}, {Long.MIN_VALUE, 1, Long.MIN_VALUE},
            {Long.MAX_VALUE, 2, -2}, {Long.MIN_VALUE, Long.MIN_VALUE, 0}};
    }

    @DataProvider(name = MUL_DOUBLE_DATA_PROVIDER)
    public Object[][] doubleMulTestDataProvider() {
        return new Object[][] {{0.0, 0.0, 0.0, 0.1}, {54.345, 3.765, 204.0, 0.1},
            {-65.12, 2.02, -132.0, 0.5}, {23, -567.51, -13053.0, 0.1},
            {Double.MAX_VALUE, 0, 0, 0.1}, {Double.MIN_VALUE, 0, 0, 0.1},
            {Double.MIN_VALUE, 1, 0.0, 0.1}, {Double.MAX_VALUE, 1, Double.MAX_VALUE, 0.1},
            {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.1},
            {Double.MIN_VALUE, Double.MIN_VALUE, 0, 0.1},
            {Double.MIN_VALUE, Double.MAX_VALUE, 0, 0.1},
            {Double.MAX_VALUE, Double.MIN_VALUE, 0, 0.1}};
    }

    @DataProvider(name = DIV_LONG_DATA_PROVIDER)
    public Object[][] longDivDataProvider() {
        return new Object[][] {{12, 2, 6}, {1563, 17, 91},
            {65565, 65565, 1}, {-224, 224, -1}, {843412, 4534567, 0},
            {Long.MAX_VALUE, 1, Long.MAX_VALUE}, {Long.MAX_VALUE, Long.MAX_VALUE, 1},
            {Long.MIN_VALUE, 1, Long.MIN_VALUE}, {Long.MIN_VALUE, Long.MIN_VALUE, 1}};
    }

    @DataProvider(name = DIV_DOUBLE_DATA_PROVIDER)
    public Object[][] doubleDivDataProvider() {
        return new Object[][] {{0.0, 1.0, 0.0, 0.1}, {0.0, -1.0, 0.0, 0.1},
            {323.324, 1, 323.324, 0.001},
            {-65622.4343, 965.32, -67.979, 0.001},
            {Double.MAX_VALUE, 1, Double.MAX_VALUE, 0.5},
            {Double.MIN_VALUE, 1, Double.MIN_VALUE, 0.001},
            {Double.MAX_VALUE, Double.MAX_VALUE, 1, 0.001},
            {Double.MIN_VALUE, Double.MIN_VALUE, 1, 0.001},
            {Double.MAX_VALUE, 0, Double.POSITIVE_INFINITY, 0.001},
            {Double.MIN_VALUE, 0, Double.POSITIVE_INFINITY, 0.001},
            {-Double.MAX_VALUE, 0, Double.NEGATIVE_INFINITY, 0.001},
            {-Double.MIN_VALUE, 0, Double.NEGATIVE_INFINITY, 0.001}};
    }

    @DataProvider(name = DIV_BY_ZERO_DATA_PROVIDER)
    public Object[][] longDivByZeroDataProvider() {
        return new Object[][] {{0, 0}, {454, 0}, {-1767, 0},
            {Long.MAX_VALUE, 0}, {Long.MIN_VALUE, 0}};
    }
}
