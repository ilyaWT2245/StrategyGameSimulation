package com.github.pozzrar.strategygame.structures;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>{
    private final int DEFAULT_CAPACITY = 10;

    private E[] elementsData;

    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("Invalid capacity: " + capacity);
        }
        elementsData = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elementsData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(MyCollection<? extends E> c) {
        addAll(c);
        size = c.size();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void extend() {
        int newCapacity = elementsData.length * 2;
        E[] tmp = elementsData;
        elementsData = (E[]) new Object[newCapacity];
        System.arraycopy(tmp, 0, elementsData, 0, tmp.length);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        return getIndexOf((E) o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int curIndex = 0;
            @Override
            public boolean hasNext() {
                return curIndex != size;
            }

            @Override
            public E next() {
                return elementsData[curIndex++];
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        for (int i = 0; i < size; i++) {
            a[i] = (T) elementsData[i];
        }
        return a;
    }

    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean add(E e) {
        return insert(e, size);
    }

    public boolean insert(E e, int index) {
        checkCapacity();

        for (int i = size - 1; i >= index; i--) {
            elementsData[i + 1] = elementsData[i];
        }
        elementsData[Math.min(index, size)] = e;
        size++;
        return true;
    }

    public E set(E e, int index) {
        E element = get(index);
        elementsData[index] = e;
        return element;
    }

    private void checkCapacity() {
        if (size == elementsData.length) {
            extend();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        int index = getIndexOf((E) o);
        for (int i = index; i < size; i++) {
            elementsData[i] = (i == size - 1) ? null : elementsData[i + 1];
        }
        size = index < 0 ? size : size - 1;
        return index >= 0;
    }

    @Override
    public E get(int index) {
        checkIfOOB(index, size - 1);
        return elementsData[index];
    }

    public int getIndexOf(E e) {
        if (e != null) {
            for (int i = 0; i < size; i++) {
                if (e.equals(elementsData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void checkIfOOB(int index, int rightBound) {
        if (index < 0 || index > rightBound) {
            throw new RuntimeException("Index out of bounds: " + index);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        elementsData = (E[]) new Object[DEFAULT_CAPACITY];
    }
}
