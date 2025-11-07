package ru.sivkova.collecting;

import ru.sivkova.validator.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSize implements Collecting <String, Map<Integer, List<String>>>{
    private List<String> input;
    private Map<Integer, List<String>> resultCollecting;

    public List<String> getInput() {
        return input;
    }

    public Map<Integer, List<String>> getResultCollecting() {
        return resultCollecting;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        Map<Integer, List<String>> newCollection = new HashMap<>();
        this.resultCollecting = Collecting3_4.collectCollecting(input, newCollection, this);
    }

    public StringSize(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        Map<Integer, List<String>> newCollection = new HashMap<>();
        this.resultCollecting = Collecting3_4.collectCollecting(input, newCollection, this);
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Сформированные коллекции строк по длине: " + resultCollecting;
    }

    @Override
    public void collect(Map<Integer, List<String>> collection, String str) {
        int size = str.length();
        if (!collection.containsKey(size)) {
            collection.put(size, new ArrayList<>());
        }
        collection.get(size).add(str);
    }
}
