package ru.sivkova.function;

import ru.sivkova.validator.Validator;

import java.util.List;

public class String3_1 implements Function<String, Integer> {
    private List<String> input;
    private List<Integer> resultFunction;

    public List<String> getInput() {
        return input;
    }

    public List<Integer> getResultFunction() {
        return resultFunction;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    public String3_1(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Список длин строк: " + resultFunction;
    }

    @Override
    public Integer apply(String str) {
        return str.length();
    }
}
