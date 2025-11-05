package ru.sivkova.filter;

import ru.sivkova.validator.*;
import java.util.List;

public class String3_2 implements Filter<String> {
    private List<String> input;
    private List<String> resultFilter;

    public List<String> getInput() {
        return input;
    }

    public List<String> getResultFilter() {
        return resultFilter;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    public String3_2(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Отфильтрованные строки (длина >= 3): " + resultFilter;
    }

    @Override
    public boolean test(String obj) {
        return obj.length() >= 3;
    }
}
