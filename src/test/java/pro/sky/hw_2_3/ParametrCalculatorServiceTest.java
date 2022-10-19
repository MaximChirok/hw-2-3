package pro.sky.hw_2_3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.hw_2_3.exceptions.DivideByZeroException;
import pro.sky.hw_2_3.service.CalculatorService;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ParametrCalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest (Integer a, Integer b, Integer result) {
        assertThat(calculatorService.plus(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest (Integer a, Integer b, Integer result) {
        assertThat(calculatorService.minus(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest (Integer a, Integer b, Integer result) {
        assertThat(calculatorService.multiply(a,b)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest (Integer a, Integer b, Double result) {
        if(b==0) {
            assertThatExceptionOfType(DivideByZeroException.class)
                    .isThrownBy(()->calculatorService.divide(a,b))
                    .withMessage("На 0 делить нельзя!");
        } else {
            assertThat(calculatorService.divide(a,b)).isEqualTo(result);
        }

    }

    public static Stream<Arguments> paramsForPlus() {
        return Stream.of(
                Arguments.of(1,2,3)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(1,2,-1)
        );
    }

    public static Stream<Arguments> paramsForMultiply() {
        return Stream.of(
                Arguments.of(1,2,2)
        );
    }

    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(3,2,1.5),
                Arguments.of(3,0,null)
        );
    }

}
