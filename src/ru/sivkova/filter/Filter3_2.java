package ru.sivkova.filter;

import java.util.ArrayList;
import java.util.List;

public class Filter3_2 {
    public static <T> List<T> testFilter(List<T> list, Filter<T> filter) {
        if (list == null || filter == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null.");
        }
        List<T> result = new ArrayList<>();
        for (T val : list) {
            if (filter.test(val)) {
                result.add(val);
            }
        }
        return result;
    }
}
