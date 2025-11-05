package ru.sivkova.reduction;

import ru.sivkova.validator.Validator;

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
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reducReduction(input, this, "");
    }

    public String3_3(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reducReduction(input, this, "");
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Сформированная строка: " + resultReduction;
    }

    @Override
    public String reduc(String str, String obj) {
        return str + obj;
    }
}