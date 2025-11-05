package ru.sivkova.function;

import ru.sivkova.validator.Validator;

import java.util.List;

public class IntegerMas3_1 implements Function<int[], Integer> {
    private List<int[]> input;
    private List<Integer> resultFunction;

    public List<int[]> getInput() {
        return input;
    }

    public List<Integer> getResultFunction() {
        return resultFunction;
    }

    public void setInput(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    public IntegerMas3_1(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFunction = Function3_1.applyFunction(input, this);
    }

    @Override
    public String toString() {
        String str = "Список исходных массивов: \n";
        int i = 0;
        for (int[] mas : this.input) {
            str += "Массив " + (i + 1) + ": ";
            for (int j = 0; j < mas.length; j++) {
                str = str + mas[j] + " ";
            }
            str += "\n";
            i++;
        }
        str += "Максимальные значения каждого массива: " + resultFunction;
        return str;
    }

    @Override
    public Integer apply(int[] obj) {
        int max = obj[0];
        for (int i = 1; i < obj.length; i++) {
            if (obj[i] > max) {
                max = obj[i];
            }
        }
        return max;
    }
}