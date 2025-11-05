package ru.sivkova.box;

import java.util.List;

public class Maximum {
    public static double findMax(List<GeneralizedBox<? extends Number>> boxes) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Массив коробок пустой.");
        }
        double max = -Double.MAX_VALUE;
        boolean find = false;
        for (int i = 0; i < boxes.size(); i++)  {
            if (!boxes.get(i).isEmpty()) {
                Number val = boxes.get(i).getObj();
                if (!find) {
                    max = val.doubleValue();
                    find = true;
                } else if (val.doubleValue() > max) {
                    max = val.doubleValue();
                }
            }
        }
        if (!find) {
            throw new IllegalArgumentException("Все коробки пустые.");
        }
        return max;
    }
}
