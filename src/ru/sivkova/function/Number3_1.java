package ru.sivkova.function;

import java.util.List;
import java.util.ArrayList;

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
        this.input = input;
    }

    public Number3_1(List<Number> input) {
        this.input = input;
        this.resultFunction = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Список исходных чисел: \n" + input + "\n"
                + "Список положительных чисел: \n" + resultFunction;
    }

    public void function() {
        for (Number num : this.input) {
            this.resultFunction.add(apply(num));
        }
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