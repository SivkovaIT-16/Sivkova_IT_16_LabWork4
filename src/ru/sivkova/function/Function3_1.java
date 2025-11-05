package ru.sivkova.function;

import java.util.List;
import java.util.ArrayList;

public class Function3_1 {
    public static <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        if (list == null || function == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null.");
        }
        List<P> result = new ArrayList<>();
        for (T val : list) {
            result.add(function.apply(val));
        }
        return result;
    }
}
