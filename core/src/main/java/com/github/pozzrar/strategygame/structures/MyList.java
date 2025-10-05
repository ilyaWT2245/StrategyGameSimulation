package com.github.pozzrar.strategygame.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public interface MyList<E> extends MyCollection<E> {

    <T> T[] toArray(T[] a);

    boolean contains(Object o);

    boolean addAll(MyCollection<? extends E> c);

    @Override
    default void forEach(Consumer<? super E> action) {
        MyCollection.super.forEach(action);
    }
}
