package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends CalculatorBaseTest {

    @Test(dataProvider = "SubtractTestData")
    public void subtractTest(int a, int b, long expected) {
        System.out.printf("%d - %d\n", a, b);
        long actual = calculator.sub(a, b);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
