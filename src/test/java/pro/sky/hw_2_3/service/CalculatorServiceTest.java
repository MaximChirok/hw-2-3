package pro.sky.hw_2_3.service;

import org.junit.jupiter.api.Test;
import pro.sky.hw_2_3.exceptions.DivideByZeroException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus(2,3);
        assertThat(actual).isEqualTo(5);
        actual = calculatorService.plus(-3,2);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(2,3);
        assertThat(actual).isEqualTo(-1);
        actual = calculatorService.minus(-3,2);
        assertThat(actual).isEqualTo(-5);
    }

    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(2,3);
        assertThat(actual).isEqualTo(6);
        actual = calculatorService.multiply(-3,2);
        assertThat(actual).isEqualTo(-6);
    }

    @Test
    public void dividePossitiveTest() {
        Number actual = calculatorService.divide(5,2);
        assertThat(actual).isEqualTo(2.5);
//        actual = calculatorService.divide(-4,2);
//        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void divideNegativeTest() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(1,0))
                .withMessage("На 0 делить нельзя!");

        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(-4,0))
                .withMessage("На 0 делить нельзя!");
    }
}
