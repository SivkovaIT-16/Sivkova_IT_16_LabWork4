package ru.sivkova.function;

import java.util.List;
import java.util.ArrayList;

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
        this.input = input;
    }

    public IntegerMas3_1() {
        this.input = new ArrayList<>();
        this.resultFunction = new ArrayList<>();
    }

    public IntegerMas3_1(List<int[]> input) {
        this.input = input;
        this.resultFunction = new ArrayList<>();
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

    public void function() {
        for (int[] mas : this.input) {
            this.resultFunction.add(apply(mas));
        }
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