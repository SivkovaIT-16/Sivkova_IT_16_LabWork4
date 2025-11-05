package ru.sivkova.function;

import ru.sivkova.validator.*;
import java.util.List;
import static java.lang.Math.abs;

public class Number3_1 implements Function<Number, Number> {
    private List<Number> input;
    private List<Number> resultFunction;

    public List<Number> getInput() {
        return input;
    }

    public List<Number> getResultFunction() {
        return resultFunction;
    }

    public void setInput(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    public Number3_1(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    @Override
    public String toString() {
        return "Список исходных чисел: " + input + "\n"
                + "Список положительных чисел: " + resultFunction;
    }

    @Override
    public Number apply(Number obj) {
        String str = "" + obj;
        if (Validator.valIsInt(str)) {
            return abs(obj.intValue());
        }
        return abs(obj.doubleValue());
    }
}