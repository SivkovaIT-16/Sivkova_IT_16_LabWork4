public class Maximum {
    static public double findMax(GeneralizedBox <? extends Number>[] boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Массив коробок пустой.");
        }
        double max = 0;
        boolean find = false;
        for (GeneralizedBox <? extends Number> box : boxes) {
            if (!box.isEmpty()) {
                Number val = box.getObj();
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
