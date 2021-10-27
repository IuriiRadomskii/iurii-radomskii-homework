package com.epam.tc.hw1.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends CalculatorBaseTest {

    @Test(dataProvider = "DivideTestData")
    public void divideTest(long a, long b, double expected) {
        System.out.printf("%s / %s\n", a, b);
        if (b == 0) {
            Assertions.assertThatThrownBy(
                () -> calculator.div(a, b)
            ).as("Divide by zero").isInstanceOf(NumberFormatException.class);
        } else {
            String msg = String.format("Failed to divide %s by %s", a, b);
            double actual = calculator.div(a, b);
            Assertions.assertThat(actual).as(msg).isEqualTo(expected);
        }
    }
}
