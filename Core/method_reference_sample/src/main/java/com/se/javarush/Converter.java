package com.se.javarush;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
