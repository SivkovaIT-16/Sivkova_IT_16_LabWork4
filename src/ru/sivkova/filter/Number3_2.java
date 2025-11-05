package ru.sivkova.filter;

import java.util.List;
import java.util.ArrayList;

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
        this.input = input;
    }

    public Number3_2(List<Number> input) {
        this.input = input;
        this.resultFilter = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Список исходных чисел: " + input + "\n"
                + "Отфильтрованные числа (положительные): " + resultFilter;
    }
    public void filter() {
        for (Number num : this.input) {
            if (test(num)) {
                this.resultFilter.add(num);
            }
        }
    }

    @Override
    public boolean test(Number obj) {
        return obj.doubleValue() > 0;
    }
}