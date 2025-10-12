package com.github.pozzrar.strategygame.test;

import com.github.pozzrar.strategygame.structures.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

class MyArrayListTest {

    private MyArrayList<Integer> list;
    private MyArrayList<String> stringList;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
        stringList = new MyArrayList<>();
    }

    // Тестирование создания списка с отрицательной вместимостью
    @Test
    void testConstructorWithInvalidCapacity() {
        assertThrows(RuntimeException.class, () -> new MyArrayList<>(-1));
    }

    // Тестирование конструктора копирования из другой коллекции
    @Test
    void testConstructorWithCollection() {
        MyArrayList<Integer> sourceList = new MyArrayList<>();
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(3);

        MyArrayList<Integer> newList = new MyArrayList<>(sourceList);
        assertEquals(3, newList.size());
        assertEquals(1, newList.get(0));
        assertEquals(2, newList.get(1));
        assertEquals(3, newList.get(2));
    }

    // Тестирование получения элементов по недопустимым индексам
    @Test
    void testGetOutOfBounds() {
        list.add(10);
        assertThrows(RuntimeException.class, () -> list.get(-1));
        assertThrows(RuntimeException.class, () -> list.get(1));
    }

    // Тестирование вставки элемента в середину списка
    @Test
    void testInsert() {
        list.add(10);
        list.add(30);
        assertTrue(list.insert(20, 1));

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    // Тестирование вставки элемента в начало списка
    @Test
    void testInsertAtBeginning() {
        list.add(20);
        list.add(30);
        assertTrue(list.insert(10, 0));

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    // Тестирование вставки элемента в конец списка
    @Test
    void testInsertAtEnd() {
        list.add(10);
        list.add(20);
        assertTrue(list.insert(30, 2));

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    // Тестирование установки значений по недопустимым индексам
    @Test
    void testSetOutOfBounds() {
        list.add(10);
        assertThrows(RuntimeException.class, () -> list.set(20, -1));
        assertThrows(RuntimeException.class, () -> list.set(20, 1));
    }

    // Тестирование удаления первого элемента списка
    @Test
    void testRemoveFirstElement() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(list.remove(10));
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
    }

    // Тестирование удаления последнего элемента списка
    @Test
    void testRemoveLastElement() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(list.remove(30));
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    // Тестирование удаления несуществующего элемента
    @Test
    void testRemoveNullElement() {
        MyArrayList<String> listWithNull = new MyArrayList<>();
        listWithNull.add("a");
        listWithNull.add(null);
        listWithNull.add("c");

        assertFalse(listWithNull.remove("nonexistent"));
    }

    // Тестирование поиска индекса элемента
    @Test
    void testGetIndexOf() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(1, list.getIndexOf(20));
        assertEquals(0, list.getIndexOf(10));
        assertEquals(2, list.getIndexOf(30));
        assertEquals(-1, list.getIndexOf(40));
        assertEquals(-1, list.getIndexOf(null));
    }

    // Тестирование добавления пустой коллекции
    @Test
    void testAddAllWithEmptyCollection() {
        MyArrayList<Integer> emptyList = new MyArrayList<>();
        assertFalse(list.addAll(emptyList));
        assertEquals(0, list.size());
    }

    // Тестирование преобразования списка в массив
    @Test
    void testToArray() {
        list.add(10);
        list.add(20);
        list.add(30);

        Integer[] array = new Integer[3];
        Integer[] result = list.toArray(array);

        assertArrayEquals(new Integer[]{10, 20, 30}, result);
        assertSame(array, result);
    }

    // Тестирование автоматического расширения массива при переполнении
    @Test
    void testAutoResize() {
        MyArrayList<Integer> smallList = new MyArrayList<>(2);

        smallList.add(1);
        smallList.add(2);
        smallList.add(3); // Должно вызвать extend()


        assertEquals(3, smallList.size());
        assertEquals(1, smallList.get(0));
        assertEquals(2, smallList.get(1));
        assertEquals(3, smallList.get(2));
    }

    // Комплексное тестирование нескольких операций подряд
    @Test
    void testMultipleOperations() {
        list.add(10);
        list.add(20);
        list.insert(15, 1);
        list.set(25, 2);
        list.remove(10);

        assertEquals(2, list.size());
        assertEquals(15, list.get(0));
        assertEquals(25, list.get(1));
        assertTrue(list.contains(25));
        assertFalse(list.contains(10));
    }
}
