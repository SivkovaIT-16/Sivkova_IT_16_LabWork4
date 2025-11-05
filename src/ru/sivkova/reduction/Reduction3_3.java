package ru.sivkova.reduction;

import java.util.List;

public class Reduction3_3 {
    public static <T> T reducReduction(List<T> list, Reduction<T> reduction, T initialValue) {
        if (list == null || reduction == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null.");
        }
        if (list.isEmpty()) {
            return initialValue;
        }
        T result = initialValue;
        for (T val : list) {
            result = reduction.reduc(result, val);
        }
        return result;
    }
}
