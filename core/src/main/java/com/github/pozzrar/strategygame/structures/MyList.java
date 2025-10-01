package com.github.pozzrar.strategygame.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public interface MyList<E> extends Collection<E> {
    @Override
    int size();

    @Override
    boolean isEmpty();

    @Override
    boolean contains(Object o);

    @Override
    Iterator<E> iterator();

    @Override
    <T> T[] toArray(T[] a);

    @Override
    boolean add(E e);

    @Override
    boolean remove(Object o);

    @Override
    void clear();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    boolean retainAll(Collection<?> c);

    @Override
    boolean removeAll(Collection<?> c);

    @Override
    boolean addAll(Collection<? extends E> c);

    @Override
    boolean containsAll(Collection<?> c);

    @Override
    Object[] toArray();

    @Override
    default void forEach(Consumer<? super E> action) {
        Collection.super.forEach(action);
    }
}
