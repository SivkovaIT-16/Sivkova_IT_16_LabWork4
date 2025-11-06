package ru.sivkova.filter;

import ru.sivkova.validator.Validator;
import java.util.List;

public class Number3_2 implements Filter<Number> {
    private List<Number> input;
    private List<Number> resultFilter;

    public List<Number> getInput() {
        return input;
    }

    public List<Number> getResultFilter() {
        return resultFilter;
    }

    public void setInput(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    public Number3_2(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    @Override
    public String toString() {
        return "Список исходных чисел: " + input + "\n"
                + "Отфильтрованные числа (положительные): " + resultFilter;
    }

    @Override
    public boolean test(Number obj) {
        return obj.doubleValue() > 0;
    }
}