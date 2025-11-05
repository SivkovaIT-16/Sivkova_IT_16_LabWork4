import ru.sivkova.validator.Validator;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Number3_4 implements Collecting <Number, Map<String, List<Number>>> {
    private List<Number> input;
    private Map<String, List<Number>> resultCollecting;

    public List<Number> getInput() {
        return input;
    }

    public Map<String, List<Number>> getResultCollecting() {
        return resultCollecting;
    }

    public void setInput(List<Number> input) {
        this.input = input;
    }

    public Number3_4(List<Number> input) {
        this.input = input;
        this.resultCollecting = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Список исходных чисел: " + input + "\n"
                + "Сформированные коллекции: " + resultCollecting;
    }

    public void collecting() {
        Map<String, List<Number>> result = create();
        for (Number num : this.input) {
            betrayal(result, num);
        }
        this.resultCollecting = result;
    }

    public Map<String, List<Number>> create() {
        return new HashMap<>();
    }

    public void betrayal(Map<String, List<Number>> map, Number number) {
        String category = "";
        if (number.doubleValue() > 0) {
            category = "Положительные";
        } else if (number.doubleValue() < 0){
            category = "Отрицательные";
        } else {
            return;
        }
        if (!map.containsKey(category)) {
            map.put(category, new ArrayList<Number>());
        }
        map.get(category).add(number);
    }
    @Override
    public Map<String, List<Number>> collect(Number obj,
                                             CollectionFactory<Map<String, List<Number>>> collectionFactory,
                                             Betrayal<Number, Map<String, List<Number>>> betrayal) {
        Map<String, List<Number>> result = collectionFactory.create();
        for (Number num : this.input) {
            betrayal.betrayal(result, num);
        }

        return result;
    }
}
