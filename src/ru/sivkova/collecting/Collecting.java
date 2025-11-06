package ru.sivkova.collecting;

public interface Collecting <T, P> {
    void collect(P collection, T element);
}
