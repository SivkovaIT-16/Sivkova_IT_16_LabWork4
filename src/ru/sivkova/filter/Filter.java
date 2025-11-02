package ru.sivkova.filter;

public interface Filter <T> {
    boolean test(T obj);
}
