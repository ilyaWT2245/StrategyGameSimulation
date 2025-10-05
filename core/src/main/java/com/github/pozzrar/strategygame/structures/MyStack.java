package com.github.pozzrar.strategygame.structures;

import java.util.Iterator;

public class MyStack<E> implements Iterable<E>{
    private final MyLinkedList<E> stack;

    public MyStack() {
        stack = new MyLinkedList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean push(E e) {
        return stack.addFirst(e);
    }

    private void addLast(E e) {
        stack.add(e);
    }

    public E pop() {
        return stack.pop();
    }

    public E peek() {
        return stack.getFirst();
    }

    public void clear() {
        stack.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter != stack.size();
            }

            @Override
            public E next() {
                E element = pop();
                addLast(element);
                counter++;
                return element;
            }
        };
    }
}
