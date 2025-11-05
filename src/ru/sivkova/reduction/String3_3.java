package ru.sivkova.reduction;

import java.util.List;

public class String3_3 implements Reduction<String> {
    private List<String> input;
    private String resultReduction;

    public List<String> getInput() {
        return input;
    }

    public String getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public String3_3(List<String> input) {
        this.input = input;
        this.resultReduction = "";
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Сформированная строка: " + resultReduction;
    }

    public void reduction() {
        for (String str : this.input) {
            this.resultReduction = reduc(this.resultReduction, str);
        }
    }

    @Override
    public String reduc(String str, String obj) {
        return str + obj;
    }
}