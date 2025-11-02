package ru.sivkova.function;

public interface Function <T, P> {
    P apply(T obj);
}
