package ru.sivkova.filter;

import java.util.ArrayList;
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
        this.input = input;
    }

    public String3_2(List<String> input) {
        this.input = input;
        this.resultFilter = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Отфильтрованные строки (длина >= 3): " + resultFilter;
    }

    public void filter() {
        for (String str : this.input) {
            if (test(str)) {
                this.resultFilter.add(str);
            }
        }
    }

    @Override
    public boolean test(String obj) {
        return obj.length() >= 3;
    }
}
