package pro.sky.hw_2_3.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw_2_3.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

   private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return calculatorService.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a==null || b==null) {
            return "Не правильно переданы параметры";
        }
        return buildString(a, b, calculatorService.plus(a, b), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a==null || b==null) {
            return "Не правильно переданы параметры";
        }
        return buildString(a, b, calculatorService.minus(a, b), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a==null || b==null) {
            return "Не правильно переданы параметры";
        }
        return buildString(a,b, calculatorService.multiply(a, b), "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a==null || b==null) {
            return "Не правильно переданы параметры";
        }
            return buildString (a, b, calculatorService.divide(a, b), "/" );
    }


    public String buildString (Number a, Number b, Number result, String operation) {
        return String.format("%s %s %s = %s", a, operation, b, result);
    }

}
