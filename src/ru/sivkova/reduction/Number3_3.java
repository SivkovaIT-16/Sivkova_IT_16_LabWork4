package ru.sivkova.reduction;

import ru.sivkova.validator.Validator;

import java.util.List;

public class Number3_3 implements Reduction<Number> {
    private List<Number> input;
    private Number resultReduction;

    public List<Number> getInput() {
        return input;
    }

    public Number getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reducReduction(input, this, 0);
    }

    public Number3_3(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = Reduction3_3.reducReduction(input, this, 0);
    }

    @Override
    public String toString() {
        return "Список исходных чисел: " + input + "\n"
                + "Сумма всех значений исходного списка: " + resultReduction;
    }


    @Override
    public Number reduc(Number sum, Number obj) {
        String sumStr = sum.toString();
        String objStr = obj.toString();
        if (Validator.valIsInt(sumStr) && Validator.valIsInt(objStr)) {
            return Integer.parseInt(sumStr) + Integer.parseInt(objStr);
        }
        return Double.parseDouble(sumStr) +  Double.parseDouble(objStr);
    }
}