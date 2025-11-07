package ru.sivkova.reduction;

import ru.sivkova.function.*;
import ru.sivkova.validator.Validator;
import java.util.List;

public class IntegerMas3_3 {
    private List<int[]> input;
    private Integer resultReduction;

    public List<int[]> getInput() {
        return input;
    }

    public Integer getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = calculateElements();
    }

    public IntegerMas3_3(List<int[]> input) {
        Validator.validateNull(input);
        this.input = input;
        this.resultReduction = calculateElements();
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
        str += "Общее количество элементов: " + resultReduction;
        return str;
    }

    private Integer calculateElements() {
        List<Integer> sizes = Function3_1.applyFunction(input, new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] array) {
                return array.length;
            }
        });

        return Reduction3_3.reducReduction(sizes, new Reduction<Integer>() {
            @Override
            public Integer reduc(Integer res, Integer obj) {
                return res + obj;
            }
        }, 0);
    }
}