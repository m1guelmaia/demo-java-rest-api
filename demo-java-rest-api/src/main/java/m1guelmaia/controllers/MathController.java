package m1guelmaia.controllers;


import m1guelmaia.exception.UnsupportedMathOperationException;
import m1guelmaia.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static m1guelmaia.request.converters.NumberConverter.convertToDouble;
import static m1guelmaia.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath simpleMath = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter valid numbers.");
        return simpleMath.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter valid numbers.");
        return simpleMath.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter valid numbers.");
        return simpleMath.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter valid numbers.");
        Double secondNumber = convertToDouble(numberTwo);
        if (isZero(secondNumber))
            throw new UnsupportedMathOperationException("You cannot divide by zero.");
        return simpleMath.division(convertToDouble(numberOne), secondNumber);
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please enter valid numbers.");
        return simpleMath.average(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(
            @PathVariable("number") String number
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(number))
            throw new UnsupportedMathOperationException("Please enter valid numbers.");
        Double firstNumber = convertToDouble(number);
        if (isNegative(firstNumber))
            throw new UnsupportedMathOperationException("Please enter zero or a positive number.");
        return simpleMath.squareRoot(firstNumber);
    }

    private boolean isZero(double number) {
        if (number == 0) return true;
        return false;
    }

    private boolean isNegative(double number) {
        if (number < 0) return true;
        return false;
    }
}
