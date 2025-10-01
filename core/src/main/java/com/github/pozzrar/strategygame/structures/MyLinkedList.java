package com.github.pozzrar.strategygame.structures;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    Node<E> head;
    Node<E> tail;
    int size;

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;

        public Node(Node<T> next, Node<T> prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public Node(T value) {
            this(null, null, value);
        }

        public Node() {
            this(null, null, null);
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        return head != null ? head.value : null;
    }

    public E getLast() {
        return tail != null ? tail.value : null;
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        return node != null ? node.value : null;
    }

    private Node<E> getNode(int index) {
        Node<E> cur;
        if (index > size/2) {
            cur = tail;
            for (int i = size - 1; i != index; i--) {
                cur = cur.prev;
            }
        } else {
            cur = head;
            for (int i = 0; i != index; i++) {
                cur = cur.next;
            }
        }
        return cur;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.value == null) {
                    return true;
                }
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.value.equals(o)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                cur = cur.next;
                return cur.value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return this.toArray(new Object[size]);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int cur = 0;
        for (Node<E> node = head; node != null; node = node.next) {
            a[cur] = (T) node.value;
        }
        return a;
    }

    public boolean addLast(E e) {
        if (size == 0) {
            head = tail = new Node<>(e);
        } else {
            tail = new Node<>(null, tail, e);
        }
        size++;
        return true;
    }

    public boolean addFirst(E e) {
        if (size == 0) {
            head = tail = new Node<>(e);
        } else {
            head = new Node<>(head, null, e);
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    @Override
    public boolean remove(Object o) {
        for (Node<E> node = head; node != null; node = node.next) {
            if (o.equals(node.value)) {
                if (node == head) {
                    pop();
                    return true;
                } else {
                    node.prev.next = node.next;
                    if (node.next != null) {
                        node.next.prev = node.prev;
                    }
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public E pop() {
        if (head == null) return null;

        E value = head.value;
        head = head.next;
        return value;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean out = false;
        for (E e: c) {
            out = addLast(e);
        }
        return out;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> next = node.next;
            node.value = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        head = null;
        tail = null;
        size = 0;
    }
}
