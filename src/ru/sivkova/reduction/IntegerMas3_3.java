package ru.sivkova.reduction;

import java.util.List;

public class IntegerMas3_3 implements Reduction<Integer> {
    private List<int[]> input;
    private Integer resultReduction;

    public List<int[]> getInput() {
        return input;
    }

    public Integer getResultReduction() {
        return resultReduction;
    }

    public void setInput(List<int[]> input) {
        this.input = input;
    }

    public IntegerMas3_3(List<int[]> input) {
        this.input = input;
        this.resultReduction = 0;
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

    public void reduction() {
        for (int[] mas : this.input) {
            this.resultReduction = reduc(this.resultReduction, mas.length);
        }
    }

    @Override
    public  Integer reduc(Integer count, Integer objSize) {
        return count + objSize;
    }
}