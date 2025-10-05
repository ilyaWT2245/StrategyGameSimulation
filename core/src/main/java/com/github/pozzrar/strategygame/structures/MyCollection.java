package com.github.pozzrar.strategygame.structures;

import java.util.function.Consumer;

public interface MyCollection<E> extends Iterable<E>{
    int size();

    boolean isEmpty();

    boolean add(E e);

    boolean remove(Object o);

    E get(int i);

    void clear();

    @Override
    default void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }
}
