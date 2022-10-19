package pro.sky.hw_2_3.service;

import org.springframework.stereotype.Service;
import pro.sky.hw_2_3.exceptions.DivideByZeroException;

@Service
public class CalculatorService {



    public String greetings() {
        return ("Добро пожаловать в калькулятор");
    }

    public Number plus(Integer a, Integer b) {
        return a+b;
    }

    public Number minus(Integer a, Integer b) {
        return a-b;
    }

    public Number multiply(Integer a, Integer b) {
        return a*b;
    }

    public Number divide(Integer a, Integer b) {
        if (b==0) {
            throw new DivideByZeroException("На 0 делить нельзя!");
        }
        return a.doubleValue() / b;
    }


}
