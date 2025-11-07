package ru.sivkova.collecting;

import ru.sivkova.validator.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUnique implements Collecting <String, Set<String>>{
    private List<String> input;
    private Set<String> resultCollecting;

    public List<String> getInput() {
        return input;
    }

    public Set<String> getResultCollecting() {
        return resultCollecting;
    }

    public void setInput(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        Set<String> newCollection = new HashSet<>();
        this.resultCollecting = Collecting3_4.collectCollecting(input, newCollection, this);
    }

    public StringUnique(List<String> input) {
        Validator.validateNull(input);
        this.input = input;
        Set<String> newCollection = new HashSet<>();
        this.resultCollecting = Collecting3_4.collectCollecting(input, newCollection, this);
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Сформированная коллекция уникальных строк: " + resultCollecting;
    }

    @Override
    public void collect(Set<String> collection, String str) {
        collection.add(str);
    }
}