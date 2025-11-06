package ru.sivkova.collecting;

import ru.sivkova.validator.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        Validator.validateNull(input);
        this.input = input;
        Map<String, List<Number>> newCollection = new HashMap<>();
        newCollection.put("Положительные", new ArrayList<>());
        newCollection.put("Отрицательные", new ArrayList<>());
        this.resultCollecting = Collecting3_4.collectCollecting(input, newCollection, this);
    }

    public Number3_4(List<Number> input) {
        Validator.validateNull(input);
        this.input = input;
        Map<String, List<Number>> newCollection = new HashMap<>();
        newCollection.put("Положительные", new ArrayList<>());
        newCollection.put("Отрицательные", new ArrayList<>());
        this.resultCollecting = Collecting3_4.collectCollecting(input, newCollection, this);
    }

    @Override
    public String toString() {
        return "Список исходных чисел: " + input + "\n"
                + "Сформированные коллекции чисел: " + resultCollecting;
    }

    @Override
    public void collect(Map<String, List<Number>> collection, Number number) {
        if (number.doubleValue() > 0) {
            collection.get("Положительные").add(number);
        } else if (number.doubleValue() < 0) {
            collection.get("Отрицательные").add(number);
        }
    }
}
