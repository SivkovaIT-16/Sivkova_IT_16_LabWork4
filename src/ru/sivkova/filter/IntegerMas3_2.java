package ru.sivkova.filter;

import ru.sivkova.validator.Validator;

import java.util.List;

public class IntegerMas3_2 implements Filter<int[]> {
    private List<int[]> input;
    private List<int[]> resultFilter;

    public List<int[]> getInput() {
        return input;
    }

    public List<int[]> getResultFilter() {
        return resultFilter;
    }

    public void setInput(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
    }

    public IntegerMas3_2(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultFilter = Filter3_2.testFilter(input, this);
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
        str += "Отфильтрованные массивы (нет ни одного положительного элемента): \n";
        int k = 0;
        for (int[] mas : this.resultFilter) {
            str += "Массив " + (k + 1) + ": ";
            for (int j = 0; j < mas.length; j++) {
                str = str + mas[j] + " ";
            }
            str += "\n";
            k++;
        }
        return str;
    }

    @Override
    public boolean test(int[] obj) {
        for (int element : obj) {
            if (element > 0) {
                return false;
            }
        }
        return true;
    }
}