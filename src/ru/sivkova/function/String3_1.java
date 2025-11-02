package ru.sivkova.function;

import java.util.List;
import java.util.ArrayList;

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
        this.input = input;
    }

    public String3_1(List<String> input) {
        this.input = input;
        this.resultFunction = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Список длин строк: " + resultFunction;
    }

    public void function() {
        for (String str : this.input) {
            this.resultFunction.add(apply(str));
        }
    }

    @Override
    public Integer apply(String obj) {
        return obj.length();
    }
}
